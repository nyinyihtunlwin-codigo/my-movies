package com.nyinyihtunlwin.data.network.service

import com.nyinyihtunlwin.data.network.URL
import com.nyinyihtunlwin.data.response.NowPlayingMovieResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(URL.NOW_PLAYING_MOVIES)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int?
    ): Observable<Response<NowPlayingMovieResponse>>

}