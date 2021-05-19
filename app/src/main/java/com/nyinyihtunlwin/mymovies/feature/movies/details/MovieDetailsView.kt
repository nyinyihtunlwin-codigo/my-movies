package com.nyinyihtunlwin.mymovies.feature.movies.details

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.nyinyihtunlwin.domain.viewstate.MovieDetailsViewState
import io.reactivex.Observable

interface MovieDetailsView : MvpView {

    fun render(viewState: MovieDetailsViewState)

    fun movieDetailsIntent(): Observable<Int>
}