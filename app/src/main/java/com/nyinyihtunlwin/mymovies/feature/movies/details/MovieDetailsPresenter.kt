package com.nyinyihtunlwin.mymovies.feature.movies.details

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.nyinyihtunlwin.domain.interactor.MovieDetailsInteractor
import com.nyinyihtunlwin.domain.viewstate.MovieDetailsViewState
import io.reactivex.Observable

class MovieDetailsPresenter(private val interactor: MovieDetailsInteractor) :
    MviBasePresenter<MovieDetailsView, MovieDetailsViewState>() {

    override fun bindIntents() {
        val movieDetailsIntent: Observable<MovieDetailsViewState> =
            intent(MovieDetailsView::movieDetailsIntent)
                .flatMap(interactor::executeMovieDetails)

        subscribeViewState(movieDetailsIntent, MovieDetailsView::render)
    }
}