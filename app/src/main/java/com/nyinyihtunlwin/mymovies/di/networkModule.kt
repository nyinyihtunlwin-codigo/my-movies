package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.data.datasource.remote.NetworkMovieDataSource
import org.koin.dsl.module.module

val networkModule = module {

    single { NetworkMovieDataSource() }
}