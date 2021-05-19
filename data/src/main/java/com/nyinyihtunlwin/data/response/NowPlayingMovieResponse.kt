package com.nyinyihtunlwin.data.response

data class NowPlayingMovieResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieResponse>,
    val status_code: Int,
    val status_message: String
)