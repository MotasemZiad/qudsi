package com.iug.qudsiapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iug.qudsiapp.model.local_storage.News

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNews(news: News)

    @Query("SELECT * FROM news_table")
    fun readAllNews(): LiveData<List<News>>
}