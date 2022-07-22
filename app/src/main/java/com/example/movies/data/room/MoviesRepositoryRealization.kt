package com.example.movies.data.room

import androidx.lifecycle.LiveData
import com.example.movies.data.model.ResultMovies

class MoviesRepositoryRealization(private val moviesDao:MoviesDao):MoviesRepository {
    override val allMovies: LiveData<List<ResultMovies>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovies(resultMovies: ResultMovies, onSuccess: () -> Unit) {
        moviesDao.insert(resultMovies)
        onSuccess()
    }

    override suspend fun deleteMovies(resultMovies: ResultMovies, onSuccess: () -> Unit) {
        moviesDao.delete(resultMovies)
        onSuccess()
    }
}