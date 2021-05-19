package com.nyinyihtunlwin.data.datasource.remote

import com.google.gson.Gson
import com.nyinyihtunlwin.data.BuildConfig
import com.nyinyihtunlwin.data.network.RestAdapter
import com.nyinyihtunlwin.data.network.service.MovieService
import com.nyinyihtunlwin.data.response.NowPlayingMovieResponse
import com.nyinyihtunlwin.domain.exception.ApiException
import com.nyinyihtunlwin.domain.exception.NetworkException
import io.reactivex.Observable
import java.io.IOException

class NetworkMovieDataSource {

    private val movieService = RestAdapter.get().create(MovieService::class.java)

    fun getNowPlayingMovies(page: Int?): Observable<NowPlayingMovieResponse> {
        return movieService.getNowPlayingMovies(BuildConfig.API_KEY, page)
            .map {
                try {
                    if (it.isSuccessful) it.body()
                    else {
                        val errorResponse = Gson().fromJson(
                            it.errorBody()?.charStream(),
                            NowPlayingMovieResponse::class.java
                        )
                        throw ApiException(errorResponse.status_message)
                    }
                } catch (e: IOException) {
                    throw NetworkException
                }
            }
    }
}