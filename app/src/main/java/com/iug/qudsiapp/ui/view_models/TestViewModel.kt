package com.iug.qudsiapp.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iug.qudsiapp.data.firebase.FirestoreRepository
import com.iug.qudsiapp.model.News
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestViewModel: ViewModel() {
    var news = FirestoreRepository.mNews
    private lateinit var repo: LiveData<MutableList<News>>
    fun getNews() {
        GlobalScope.launch {
            repo = FirestoreRepository.getNews()
        }
    }
}