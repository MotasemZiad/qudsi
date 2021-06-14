package com.iug.qudsiapp.ui.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.data.MyDatabase
import com.iug.qudsiapp.model.local_storage.News
import com.iug.qudsiapp.repository.LocalStorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalNewsViewModel(application: Application) : AndroidViewModel(application) {

    val dataNews: LiveData<List<News>>
    private val repository: LocalStorageRepository

    init {
        val userDao = MyDatabase.getDatabase(application).newsDao()
        repository = LocalStorageRepository(userDao)
        dataNews = repository.readAllData
    }

    fun addNews(news: News) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNews(news)
        }
    }

}