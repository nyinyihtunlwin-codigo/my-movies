package com.nyinyihtunlwin.mymovies.feature.base

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.hannesdorfmann.mosby3.mvi.MviPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.nyinyihtunlwin.data.network.interceptor.HttpErrorEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


abstract class BaseMviActivity<VS, VIEW : MvpView, PRESENTER : MviPresenter<VIEW, VS>> :
    MviActivity<VIEW, PRESENTER>() {

    protected var isLoading = false
    private var mProgressBar: ProgressDialog? = null

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        add(
            HttpErrorEvent.subscribe().observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { handle(it) })
        )
    }

    private fun handle(event: HttpErrorEvent.Event) {
        Log.i(javaClass.simpleName, event.type.toString())
        when (event.type) {
            HttpErrorEvent.Type.UNAUTHORIZED -> {
                //TODO: Show Login screen here
            }
            HttpErrorEvent.Type.SERVER_ERROR -> {
                //TODO: Show server error here
            }

            HttpErrorEvent.Type.MAINTENANCE -> {
                //TODO: Redirect to Maintenance screen
            }
        }
    }


    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun showToast(message: String) {
        if (message != "") Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (!compositeDisposable.isDisposed) compositeDisposable.clear()
    }

    protected fun showLoading() {
        if (!isLoading) {
            mProgressBar = ProgressDialog.show(this, "", "loading...")
            if (mProgressBar != null) {
                mProgressBar!!.show()
            }
            isLoading = true
        }
    }

    protected fun showLoading(message: String) {
        if (!isLoading) {
            mProgressBar = ProgressDialog.show(this, "", message)
            if (mProgressBar != null) {
                mProgressBar!!.show()
            }
            isLoading = true
        }
    }

    protected fun hideLoading() {
        if (isLoading) {
            if (mProgressBar != null && mProgressBar!!.isShowing) {
                mProgressBar!!.dismiss()
            }
            isLoading = false
        }
    }
}