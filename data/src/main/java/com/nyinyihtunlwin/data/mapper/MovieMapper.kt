package com.nyinyihtunlwin.data.mapper

import com.nyinyihtunlwin.data.database.entity.MovieEntity
import com.nyinyihtunlwin.data.utils.DateUtils
import com.nyinyihtunlwin.domain.model.movie.Movie

class MovieMapper(private val dateUtils: DateUtils) {

    fun mapMovieList(list: List<MovieEntity>): List<Movie> {
        val movies = arrayListOf<Movie>()
        list.forEach {
            val movie = Movie(
                it.movieId,
                it.title,
                "https://image.tmdb.org/t/p/w500${it.posterPath}",
                "https://image.tmdb.org/t/p/w500${it.backdropPath}",
                it.overview,
                dateUtils.convertDate(it.releaseDate)
            )
            movies.add(movie)
        }
        return movies
    }
}