package com.example.sampletest.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampletest.model_data.DataModelItem
import com.example.sampletest.repository.Repository
import com.example.sampletest.room_database.PostDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository, private val postDatabase: PostDatabase): ViewModel() {

    private val postLiveData = MutableLiveData<List<DataModelItem>>()
    val post :LiveData<List<DataModelItem>> get() = postDatabase.postDao().getPostsfromDao()




    fun getPost()
    {

            val response= repository.getPost()
            response.enqueue(object : Callback<List<DataModelItem>?> {
                override fun onResponse(call: Call<List<DataModelItem>?>, response: Response<List<DataModelItem>?>) {
                    if (response.isSuccessful) {
                        val movieDataGet = response.body()!!
                        Log.e("MyResponse", "Data : ${movieDataGet}")
                        viewModelScope.launch(Dispatchers.IO) {
                            postDatabase.postDao().insertPosts(response.body()!!)
                            postLiveData.postValue(response.body())
                        }


                    }
                }

                override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {
                    Log.d("Errorrrrr", t.message.toString())
                }
            })

    }
}