package com.nyinyihtunlwin.domain.viewstate

import com.nyinyihtunlwin.domain.model.movie.Movie


sealed class MovieDetailsViewState {

    class Error(val t: Throwable) : MovieDetailsViewState()

    object Progress : MovieDetailsViewState()

    class MovieDetails(val movie: Movie) : MovieDetailsViewState()

}