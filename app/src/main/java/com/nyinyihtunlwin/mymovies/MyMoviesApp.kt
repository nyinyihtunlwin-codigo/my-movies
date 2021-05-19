package com.nyinyihtunlwin.mymovies

import android.app.Application
import com.nyinyihtunlwin.mymovies.di.*
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MyMoviesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin(
            this, listOf(
                appModule, interactorModule, mapperModule, presenterModule,
                repositoryModule, networkModule, cacheModule
            )
        )
    }
}