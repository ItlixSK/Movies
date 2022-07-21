package com.example.movies.ui.start

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies.data.model.MoviesModel
import com.example.movies.data.retrofit.RetrofitRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class StartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RetrofitRepository()

    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application

    fun getMoviesRetrofit() {
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovie()
            } catch (e: Exception) {
                Log.e("ERROR", e.message.toString())
            }
        }
    }

}