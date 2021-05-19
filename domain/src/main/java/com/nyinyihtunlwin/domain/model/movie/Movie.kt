package com.nyinyihtunlwin.domain.model.movie

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val releaseDate: String, //MM-YYYY
    val posterPath: String,
    val backdropPath: String //wwww.domain.com/W500/background/test.jpg
)