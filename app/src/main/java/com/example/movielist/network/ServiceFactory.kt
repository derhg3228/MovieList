package com.example.movielist.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.kinopoisk.cloud/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService(): ApiService = retrofit.create(ApiService::class.java)
}