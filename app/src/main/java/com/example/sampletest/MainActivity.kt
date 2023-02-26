package com.example.sampletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampletest.api_interface.SampleApi
import com.example.sampletest.databinding.ActivityMainBinding
import com.example.sampletest.model_data.DataModel
import com.example.sampletest.model_data.DataModelItem
import com.example.sampletest.recycler_view.PostAdapter
import com.example.sampletest.repository.Repository
import com.example.sampletest.room_database.PostDatabase
import com.example.sampletest.view_model.MainViewFactory
import com.example.sampletest.view_model.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity()  {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var data : List<DataModelItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPostList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val retrofitService : SampleApi = SampleApi.getInstance()
        val database = PostDatabase.getDataBase(this)

        viewModel = ViewModelProvider(this,MainViewFactory(Repository(retrofitService),database)).get(MainViewModel::class.java)
        viewModel.post.observe(this, Observer {
            Log.d("MainActi", "DB: $it")
            data = it
            binding.rvPostList.adapter = PostAdapter(this@MainActivity,it)
        })
        viewModel.getPost()





    }
    fun calli(postion : Int) {
        val frag = PostFragment()
        supportFragmentManager.beginTransaction().add(R.id.root_container, frag)
            .addToBackStack(null).commit()
        val bundle = Bundle()

        bundle.putInt("id",data.get(postion).id)
        bundle.putString("body",data.get(postion).body)
        bundle.putString("title",data.get(postion).title)
        frag.arguments = bundle
        binding.rvPostList.visibility = View.INVISIBLE

    }

}