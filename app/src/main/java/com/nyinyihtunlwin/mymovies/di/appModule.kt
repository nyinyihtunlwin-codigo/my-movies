package com.nyinyihtunlwin.mymovies.di

import com.nyinyihtunlwin.data.database.entity.RoomDbHelper
import com.nyinyihtunlwin.data.executor.BackgroundThreadImpl
import com.nyinyihtunlwin.data.executor.JobsExecutor
import com.nyinyihtunlwin.data.utils.DateUtils
import com.nyinyihtunlwin.domain.executor.BackgroundThread
import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import com.nyinyihtunlwin.mymovies.executor.UiThread
import org.koin.dsl.module.module

val appModule = module {

    single { UiThread() as PostExecutionThread }

    single<BackgroundThread> { BackgroundThreadImpl(JobsExecutor()) }

    single { DateUtils() }

    single { RoomDbHelper(get()) }

}