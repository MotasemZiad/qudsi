package com.iug.qudsiapp.data.retrofit.repository


import com.iug.qudsiapp.data.retrofit.api.RetrofitInstance
import com.iug.qudsiapp.model.MyNewsResponse
import retrofit2.Response

class NewsRepository {
  suspend fun getNews(): Response<MyNewsResponse> {
     return RetrofitInstance.apiService.getNews()
  }

}