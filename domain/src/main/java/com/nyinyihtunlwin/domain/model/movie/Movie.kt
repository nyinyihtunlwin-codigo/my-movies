package com.nyinyihtunlwin.domain.model.movie

data class Movie(
    val voteCount: Int,
    val id: Int,
    val video: Boolean,
    val voteAverage: Double,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<String>,
    val backdropPath: String, //wwww.domain.com/W500/background/test.jpg
    val adult: Boolean,
    val overview: String,
    val releaseDate: String //MM-YYYY
)