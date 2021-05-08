package com.iug.qudsiapp.data.local_storage

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iug.qudsiapp.model.News

interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNews(news: News)

    @Query("SELECT * FROM news_table ORDER BY date DESC")
    fun readAllNews(): LiveData<List<News>>
}