package com.example.movies.data.room

import androidx.lifecycle.LiveData
import com.example.movies.data.model.ResultMovies

interface MoviesRepository {

    val allMovies: LiveData<List<ResultMovies>>
    suspend fun insertMovies(resultMovies: ResultMovies,onSuccess:()->Unit)
    suspend fun deleteMovies(resultMovies: ResultMovies,onSuccess: () -> Unit)
}