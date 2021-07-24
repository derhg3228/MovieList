package com.example.movielist.model

data class KinopoiskMovies(
    val movies: List<MovieModel>
)

data class MovieModel(
    val title: String,
    val description: String,
    val year: Int,
    val age: String,
    val genres: List<String>,
    val poster: String,
    val trailer: String
)