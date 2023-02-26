package com.example.sampletest.room_database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sampletest.model_data.DataModelItem
import retrofit2.Call

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertPosts(postEntity: List<DataModelItem>)

    @Query("SELECT * FROM 'post'")
    fun getPostsfromDao(): LiveData<List<DataModelItem>>
}