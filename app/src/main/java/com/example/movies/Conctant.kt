package com.example.movies

import com.example.movies.data.room.MoviesRepositoryRealization

const val API_JSON = "https://api.themoviedb.org/3/movie/popular?api_key=039f49bc47ffc1ab786dc22e246e1e93&language=ru-RU&page=1"
const val BASE_URL = "https://api.themoviedb.org/"
const val IMAGE_URL = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2"
lateinit var MAIN: MainActivity
lateinit var REALIZATION:MoviesRepositoryRealization