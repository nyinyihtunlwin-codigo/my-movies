package com.nyinyihtunlwin.domain.repository

import com.nyinyihtunlwin.domain.model.movie.Movie
import io.reactivex.Observable

interface MovieRepository {
    fun getNowPlayingMovieList(page: Int?): Observable<List<Movie>>
}