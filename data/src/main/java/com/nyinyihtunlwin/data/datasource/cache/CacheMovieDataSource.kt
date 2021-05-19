package com.nyinyihtunlwin.data.datasource.cache

import com.nyinyihtunlwin.data.database.entity.MovieEntity
import com.nyinyihtunlwin.data.database.entity.RoomDbHelper
import io.reactivex.Observable

class CacheMovieDataSource(private val dbHelper: RoomDbHelper) {

    fun saveMovies(entities: List<MovieEntity>): Observable<List<MovieEntity>> {
        dbHelper.getMovieDao().insertMovies(entities)
        return dbHelper.getMovieDao().getAllMovies().toObservable()
    }

    fun getAllMovies(): Observable<List<MovieEntity>> {
        return dbHelper.getMovieDao().getAllMovies().toObservable()
    }
}