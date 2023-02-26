package com.example.sampletest.model_data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class DataModelItem(
    @ColumnInfo(name = "userId")
    val userId: Int,
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String

)