package com.example.movies.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movies.REALIZATION
import com.example.movies.data.model.ResultMovies

class FavoriteViewModel:ViewModel() {

    fun getAllMovies():LiveData<List<ResultMovies>>{
        return REALIZATION.allMovies
    }
}