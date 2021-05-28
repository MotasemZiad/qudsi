package com.iug.qudsiapp.data.retrofit.api


import com.iug.qudsiapp.model.MyNewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/everything?q=القدس&from=2021-5-5&sortBy=popularity&apiKey=4b7cd889c6854d89be2500ad76ce221f&language=ar")
    suspend fun getNews(
    ):Response<MyNewsResponse>
}