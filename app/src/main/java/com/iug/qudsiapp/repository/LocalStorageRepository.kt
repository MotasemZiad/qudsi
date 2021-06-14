package com.iug.qudsiapp.repository

import androidx.lifecycle.LiveData
import com.iug.qudsiapp.data.NewsDao
import com.iug.qudsiapp.model.local_storage.News

class LocalStorageRepository(private val newsDao: NewsDao) {

    val readAllData: LiveData<List<News>> = newsDao.readAllNews()

    suspend fun addNews(news: News) {
        newsDao.addNews(news)
    }

}