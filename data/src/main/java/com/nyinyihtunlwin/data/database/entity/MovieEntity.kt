package com.nyinyihtunlwin.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false) var movieId: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "overview") var overview: String,
    @ColumnInfo(name = "release_date") var releaseDate: String,
    @ColumnInfo(name = "poster") var poster: String,
    @ColumnInfo(name = "original_poster") var originalPoster: String
)
