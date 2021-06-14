package com.iug.qudsiapp.repository

import com.iug.qudsiapp.network.ServiceBuilder

class APIRepository {

    suspend fun getNews(
        q : String,
        apiKey : String,
        language : String
    ) = ServiceBuilder.apis!!.getNews(q, apiKey, language)

}