package com.nyinyihtunlwin.domain.interactor

import com.nyinyihtunlwin.domain.executor.BackgroundThread
import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import com.nyinyihtunlwin.domain.repository.MovieRepository
import com.nyinyihtunlwin.domain.viewstate.MovieDetailsViewState
import io.reactivex.Observable

class MovieDetailsInteractor(
    private val movieRepository: MovieRepository,
    private val mainThread: PostExecutionThread,
    private val backgroundThread: BackgroundThread
) {
    fun executeMovieDetails(id: Int): Observable<MovieDetailsViewState> {
        return movieRepository.getMovieById(id)
            .map { MovieDetailsViewState.MovieDetails(it) }
            .cast(MovieDetailsViewState::class.java)
            .onErrorReturn { MovieDetailsViewState.Error(it) }
            .startWith(MovieDetailsViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }
}