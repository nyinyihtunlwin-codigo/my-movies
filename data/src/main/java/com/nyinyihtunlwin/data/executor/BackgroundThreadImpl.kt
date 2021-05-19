package com.nyinyihtunlwin.data.executor

import com.nyinyihtunlwin.domain.executor.BackgroundThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BackgroundThreadImpl(private val jobExecutor: JobsExecutor) : BackgroundThread {

    override fun getScheduler(): Scheduler = Schedulers.from(jobExecutor)
}