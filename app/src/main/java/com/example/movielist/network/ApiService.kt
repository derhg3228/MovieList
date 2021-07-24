package com.example.movielist.network

import com.example.movielist.model.KinopoiskMovies
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("movies/all/page/1/token/10363c2009a158b8ac81befa3d015c6c")
    fun getMovies(): Call<KinopoiskMovies>
}