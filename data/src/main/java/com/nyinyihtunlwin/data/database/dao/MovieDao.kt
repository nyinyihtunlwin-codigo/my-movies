package com.nyinyihtunlwin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nyinyihtunlwin.data.database.entity.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(entities: List<MovieEntity>): List<Long>

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Single<List<MovieEntity>>
}
