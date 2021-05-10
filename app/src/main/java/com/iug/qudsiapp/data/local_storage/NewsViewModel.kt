package com.iug.qudsiapp.data.local_storage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<News>>
    private val repository: NewsRepo

    init {
        val userDao = MyDatabase.getDatabase(application).newsDao()
        repository = NewsRepo(userDao)
        readAllData = repository.readAllData
    }

    fun addNews(news: News) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNews(news)
        }
    }

}