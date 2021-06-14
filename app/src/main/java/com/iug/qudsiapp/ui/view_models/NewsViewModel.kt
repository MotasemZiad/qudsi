package com.iug.qudsiapp.ui.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.model.api.APIResponse
import com.iug.qudsiapp.repository.APIRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel: ViewModel() {

    var repository = APIRepository()

    var dataNews = MutableLiveData<APIResponse>()

    fun getHomeNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getNews(
                "Jerusalem",
                "522f4a7cef35407c9c03f4269ae653d1",
                "ar")
            withContext(Dispatchers.Main){
                dataNews.postValue(response.body())
            }
        }
    }

}