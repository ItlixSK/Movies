package com.example.movies.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.REALIZATION
import com.example.movies.data.model.ResultMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {

    fun insert(resultMovies: ResultMovies,onSuccess:()->Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovies(resultMovies){
                onSuccess()
            }
        }
    }

    fun delete(resultMovies: ResultMovies,onSuccess: () -> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REALIZATION.deleteMovies(resultMovies){
                onSuccess()
            }
        }
    }
}