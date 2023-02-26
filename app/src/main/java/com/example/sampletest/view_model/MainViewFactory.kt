package com.example.sampletest.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampletest.repository.Repository
import com.example.sampletest.room_database.PostDatabase

class MainViewFactory(private val repository: Repository , private val postDatabase: PostDatabase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository,this.postDatabase) as T
        }
        else{
            throw IllegalArgumentException("View Model Not Found")
        }
    }
}