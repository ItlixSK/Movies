package com.example.movies.data.model

data class MoviesModel(
    val page: Int,
    val results: List<ResultMovies>,
    val total_pages: Int,
    val total_results: Int
)