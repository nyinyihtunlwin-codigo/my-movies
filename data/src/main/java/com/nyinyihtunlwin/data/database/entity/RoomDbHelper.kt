package com.nyinyihtunlwin.data.database.entity

import android.content.Context
import androidx.room.Room
import com.nyinyihtunlwin.data.database.RxDatabase
import com.nyinyihtunlwin.data.database.dao.MovieDao

class RoomDbHelper constructor(private val context: Context) {

    private val movieDao: MovieDao


    init {
        val rxDatabase: RxDatabase = Room.databaseBuilder(
            context, RxDatabase::class.java,
            "movies_db"
        )
            .fallbackToDestructiveMigration()
            .build()
        movieDao = rxDatabase.movieDao()

    }

    fun getMovieDao(): MovieDao = movieDao

}