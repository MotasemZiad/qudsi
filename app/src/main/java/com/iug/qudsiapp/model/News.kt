package com.iug.qudsiapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_table")
data class News(

    val title: String,

    @PrimaryKey
    val url: String,

    val urlToImage: String,

    val publishedAt: String,

    val description: String,

    val author: String

)