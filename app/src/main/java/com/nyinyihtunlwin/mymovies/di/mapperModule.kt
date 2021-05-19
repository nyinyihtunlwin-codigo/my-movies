package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.data.mapper.MovieMapper
import org.koin.dsl.module.module

val mapperModule = module {

    single { MovieMapper(get()) }

}