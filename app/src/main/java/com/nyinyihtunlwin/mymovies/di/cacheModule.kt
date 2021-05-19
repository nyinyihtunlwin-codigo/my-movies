package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.data.datasource.cache.CacheMovieDataSource
import org.koin.dsl.module.module

val cacheModule = module {

    single { CacheMovieDataSource(get()) }

}