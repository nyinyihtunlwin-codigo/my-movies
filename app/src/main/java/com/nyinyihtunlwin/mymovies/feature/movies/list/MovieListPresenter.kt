package com.nyinyihtunlwin.mymovies.feature.movies.list

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.nyinyihtunlwin.domain.interactor.MovieListInteractor
import com.nyinyihtunlwin.domain.viewstate.MovieListViewState
import io.reactivex.Observable

class MovieListPresenter(private val interactor: MovieListInteractor) :
    MviBasePresenter<MovieListView, MovieListViewState>() {

    override fun bindIntents() {
        val nowPlayingMovieIntent: Observable<MovieListViewState> =
            intent(MovieListView::nowPlayingMovieListIntent)
                .flatMap(interactor::executeNowPlayingMovie)

        subscribeViewState(nowPlayingMovieIntent, MovieListView::render)
    }
}