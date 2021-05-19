package com.nyinyihtunlwin.domain.interactor

import com.nyinyihtunlwin.domain.executor.BackgroundThread
import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import com.nyinyihtunlwin.domain.repository.MovieRepository
import com.nyinyihtunlwin.domain.viewstate.MovieListViewState
import io.reactivex.Observable

class MovieListInteractor(
    private val movieRepository: MovieRepository,
    private val mainThread: PostExecutionThread,
    private val backgroundThread: BackgroundThread
) {
    fun executeNowPlayingMovie(page: Int?): Observable<MovieListViewState> {
        return movieRepository.getNowPlayingMovieList(null)
            .map { MovieListViewState.MovieList(it) }
            .cast(MovieListViewState::class.java)
            .onErrorReturn { MovieListViewState.Error(it) }
            .startWith(MovieListViewState.Progress)
            .subscribeOn(backgroundThread.getScheduler())
            .observeOn(mainThread.getScheduler())
    }
}