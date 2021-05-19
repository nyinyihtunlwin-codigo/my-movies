package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.domain.interactor.MovieDetailsInteractor
import com.nyinyihtunlwin.domain.interactor.MovieListInteractor
import org.koin.dsl.module.module

val interactorModule = module {

    factory { MovieListInteractor(get(), get(), get()) }

    factory { MovieDetailsInteractor(get(), get(), get()) }
}