package com.iug.qudsiapp.data.retrofit.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iug.qudsiapp.view_models.NewsViewModelRetrofit

class NewsViewModelFactory(private val repository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModelRetrofit(repository) as T
    }
}