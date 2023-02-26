package com.example.sampletest.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sampletest.model_data.DataModelItem

@Database(entities = [DataModelItem::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object{

        @Volatile
        private var INSTANCE : PostDatabase? = null
//creating instance of our roomDB
        fun getDataBase(context:Context) : PostDatabase{
            var instance = INSTANCE

            if (instance == null)
            {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,
                "post").fallbackToDestructiveMigration().build()
                INSTANCE = instance
            }
            return instance

        }
    }
}