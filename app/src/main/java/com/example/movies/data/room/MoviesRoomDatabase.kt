package com.example.movies.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies.data.model.ResultMovies

@Database(entities = [ResultMovies::class], version = 1)
abstract class MoviesRoomDatabase: RoomDatabase() {

    abstract fun getMoviesDao():MoviesDao

    companion object{

        private var database: MoviesRoomDatabase? = null

        fun getInstance(context: Context):MoviesRoomDatabase{
            return if (database == null){
                database = Room.databaseBuilder(context,MoviesRoomDatabase::class.java,"db")
                    .build()
                database as MoviesRoomDatabase
            }else{
                database as MoviesRoomDatabase
            }
        }
    }
}