package com.iug.qudsiapp.model

data class MyNewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)