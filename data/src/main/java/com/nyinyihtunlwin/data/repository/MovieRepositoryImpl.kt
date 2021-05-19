package com.nyinyihtunlwin.data.repository

import com.nyinyihtunlwin.data.datasource.cache.CacheMovieDataSource
import com.nyinyihtunlwin.data.datasource.remote.NetworkMovieDataSource
import com.nyinyihtunlwin.data.mapper.MovieMapper
import com.nyinyihtunlwin.domain.model.movie.Movie
import com.nyinyihtunlwin.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieRepositoryImpl(
    private val networkMovieDataSource: NetworkMovieDataSource,
    private val cacheMovieDataSource: CacheMovieDataSource,
    private val movieMapper: MovieMapper
) : MovieRepository {

    override fun getNowPlayingMovieList(page: Int?): Observable<List<Movie>> {
        return networkMovieDataSource.getNowPlayingMovies(page)
            .map { movieMapper.mapMovieInfoList(it.results) }
    }

}