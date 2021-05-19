package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.data.repository.MovieRepositoryImpl
import com.nyinyihtunlwin.domain.repository.MovieRepository
import org.koin.dsl.module.module

val repositoryModule = module {

    single<MovieRepository> { MovieRepositoryImpl(get(), get(), get()) }

}