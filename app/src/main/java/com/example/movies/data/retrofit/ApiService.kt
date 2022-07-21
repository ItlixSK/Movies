package com.example.movies.data.retrofit

import com.example.movies.API_JSON
import com.example.movies.data.model.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(API_JSON)
    suspend fun getPopularMovies():Response<MoviesModel>
}