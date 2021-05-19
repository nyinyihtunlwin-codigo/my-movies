package com.nyinyihtunlwin.mymovies.executor

import com.nyinyihtunlwin.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UiThread: PostExecutionThread {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}