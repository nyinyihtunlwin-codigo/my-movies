package com.nyinyihtunlwin.domain.viewstate

import com.nyinyihtunlwin.domain.model.movie.Movie


sealed class MovieListViewState {

    class Error(val t: Throwable) : MovieListViewState()

    object Progress : MovieListViewState()

    class MovieList(val movies: List<Movie>) : MovieListViewState()

}