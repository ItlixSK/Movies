package com.example.movies.data.retrofit

import com.example.movies.data.model.MoviesModel
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovie():Response<MoviesModel>{
        return RetrofitInstance.api.getPopularMovies()
    }
}