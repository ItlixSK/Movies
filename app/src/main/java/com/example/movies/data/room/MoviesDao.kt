package com.example.movies.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movies.data.model.ResultMovies

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(resultMovies: ResultMovies)
    @Delete
    suspend fun delete(resultMovies: ResultMovies)
    @Query("SELECT * from moviesTable")
    fun getAllMovies():LiveData<List<ResultMovies>>
}