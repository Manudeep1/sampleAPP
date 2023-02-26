package com.example.sampletest.api_interface


import com.example.sampletest.model_data.DataModelItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SampleApi {

    @GET("posts")
   fun getData() : Call<List<DataModelItem>>

   companion object{
       var retrofitService : SampleApi? = null

       fun getInstance(): SampleApi{
           if(retrofitService == null)
           {
               val retrofit = Retrofit.Builder()
                   .baseUrl("https://jsonplaceholder.typicode.com/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
               retrofitService = retrofit.create(SampleApi::class.java)
           }
           return retrofitService!!
       }
   }
}