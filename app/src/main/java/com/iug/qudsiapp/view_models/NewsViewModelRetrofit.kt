package com.iug.qudsiapp.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iug.qudsiapp.data.retrofit.repository.NewsRepository
import com.iug.qudsiapp.model.MyNewsResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*

class NewsViewModelRetrofit(val repository: NewsRepository): ViewModel() {
     var _myResponse = MutableLiveData<Response<MyNewsResponse>>()

    fun getNews(){
        viewModelScope.launch {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val today = "$year-$month-$day"
            Log.e("TTT", "-->$today<--")
            val response = repository.getNews()
            _myResponse.value = response
        }
    }

}