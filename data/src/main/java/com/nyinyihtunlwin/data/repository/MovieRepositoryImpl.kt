package com.nyinyihtunlwin.data.repository

import com.nyinyihtunlwin.data.database.entity.MovieEntity
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

    /*override fun getNowPlayingMovieList(page: Int?): Observable<List<Movie>> {
        return networkMovieDataSource.getNowPlayingMovies(page)
            .map { movieMapper.mapMovieInfoList(it.results) }
    }*/

    override fun getNowPlayingMovieList(page: Int?): Observable<List<Movie>> {
        return Observable.concat(
            cacheMovieDataSource.getAllMovies()
                .flatMap {
                    if (it.isEmpty()) fetchNowPlayingMovieList(page)
                    else Observable.just(movieMapper.mapMovieList(it))
                }, fetchNowPlayingMovieList(page)
        )
    }

    private fun fetchNowPlayingMovieList(page: Int?): Observable<List<Movie>> {
        return networkMovieDataSource.getNowPlayingMovies(null)
            .map { it.results }
            .flatMapIterable { it }
            .flatMap {
                Observable.just(
                    MovieEntity(
                        it.id,
                        it.title,
                        it.overview, it.release_date, it.poster_path,
                        it.backdrop_path
                    )
                )
            }.toList().toObservable()
            .flatMap { cacheMovieDataSource.saveMovies(it) }
            .map { movieMapper.mapMovieList(it) }
    }

}