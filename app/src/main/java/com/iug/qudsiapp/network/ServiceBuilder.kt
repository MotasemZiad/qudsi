package com.iug.qudsiapp.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceBuilder {

    companion object {

        private const val baseURL = "https://"
        var apis: Api? = null


        init {
            val client = OkHttpClient.Builder()
                .build()
            apis = getRetrofitInstance(client).create(Api::class.java)
        }

        fun getRetrofitInstance(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setLenient()
                            .create()
                    )
                )
                .client(client)
                .build()

    }

}