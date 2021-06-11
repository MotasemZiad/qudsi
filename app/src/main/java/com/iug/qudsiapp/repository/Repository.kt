package com.iug.qudsiapp.repository

import com.iug.qudsiapp.network.ServiceBuilder

class Repository {

    suspend fun getNews(
        q : String,
        apiKey : String,
        language : String
    ) = ServiceBuilder.apis!!.getNews(q, apiKey, language)

}