package com.example.movies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "moviesTable")
data class ResultMovies(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,

) : Serializable