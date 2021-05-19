package com.nyinyihtunlwin.mymovies.feature.movies.list

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.nyinyihtunlwin.domain.viewstate.MovieListViewState
import io.reactivex.Observable

interface MovieListView : MvpView {

    fun render(viewState: MovieListViewState)

    fun nowPlayingMovieListIntent(): Observable<Int>
}