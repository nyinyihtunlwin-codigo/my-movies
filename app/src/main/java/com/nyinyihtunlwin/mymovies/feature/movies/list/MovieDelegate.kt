package com.nyinyihtunlwin.mymovies.feature.movies.list

import com.nyinyihtunlwin.domain.model.movie.Movie

interface MovieDelegate {
    fun onTapMovie(movie: Movie)
}