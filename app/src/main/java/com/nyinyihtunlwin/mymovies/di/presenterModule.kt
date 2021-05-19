package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.mymovies.feature.movies.details.MovieDetailsPresenter
import com.nyinyihtunlwin.mymovies.feature.movies.list.MovieListPresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory { MovieListPresenter(get()) }

    factory { MovieDetailsPresenter(get()) }

}
