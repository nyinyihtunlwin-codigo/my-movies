package com.nyinyihtunlwin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nyinyihtunlwin.data.database.dao.MovieDao
import com.nyinyihtunlwin.data.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class RxDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}