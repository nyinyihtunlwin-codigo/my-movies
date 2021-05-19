package com.nyinyihtunlwin.data.mapper

import com.nyinyihtunlwin.data.response.MovieResponse
import com.nyinyihtunlwin.data.utils.DateUtils
import com.nyinyihtunlwin.domain.model.movie.Movie

class MovieMapper(private val dateUtils: DateUtils) {

    fun mapMovieInfoList(list: List<MovieResponse>): List<Movie> {
        val movies = arrayListOf<Movie>()
        list.forEach {
            val movie = Movie(
                it.vote_count,
                it.id,
                it.video,
                it.vote_average,
                it.title,
                it.popularity,
                "https://image.tmdb.org/t/p/w500${it.poster_path}",
                it.original_language,
                it.original_title,
                it.genre_ids,
                "https://image.tmdb.org/t/p/w500${it.backdrop_path}",
                it.adult,
                it.overview,
                dateUtils.convertDate(it.release_date)
            )
            movies.add(movie)
        }
        return movies
    }
}