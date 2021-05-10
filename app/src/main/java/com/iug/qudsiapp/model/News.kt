package com.iug.qudsiapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "news_table")
data class News(
    @PrimaryKey
    val id: String,
    val content: String,
    val img: String,
    val date: Long
)