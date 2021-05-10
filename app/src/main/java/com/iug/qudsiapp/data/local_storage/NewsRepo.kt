package com.iug.qudsiapp.data.local_storage

import androidx.lifecycle.LiveData
import com.iug.qudsiapp.model.News

class NewsRepo(private val newsDao: NewsDao) {
    val readAllData: LiveData<List<News>> = newsDao.readAllNews()

    suspend fun addNews(news: News) {
        newsDao.addNews(news)
    }
}