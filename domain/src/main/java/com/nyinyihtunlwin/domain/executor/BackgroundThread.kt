package com.nyinyihtunlwin.domain.executor

import io.reactivex.Scheduler

interface BackgroundThread {

    fun getScheduler(): Scheduler

}