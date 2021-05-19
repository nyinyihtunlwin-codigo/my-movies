package com.nyinyihtunlwin.mymovies.feature.movies.list

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.nyinyihtunlwin.domain.model.movie.Movie
import com.nyinyihtunlwin.domain.viewstate.MovieListViewState
import com.nyinyihtunlwin.mymovies.databinding.ActivityMainBinding
import com.nyinyihtunlwin.mymovies.feature.base.BaseMviActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.koin.android.ext.android.inject

class MainActivity : BaseMviActivity<MovieListViewState, MovieListView, MovieListPresenter>(),
    MovieListView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: MovieAdapter

    private val mPresenter: MovieListPresenter by inject()
    private val nowPlayingMovieRelay: PublishSubject<Int> = PublishSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = MovieAdapter(this, object : MovieDelegate {
            override fun onTapMovie(movie: Movie) {

            }
        })
        binding.rvMovies.adapter = mAdapter
        binding.rvMovies.layoutManager = GridLayoutManager(this, 2)

        binding.swipeRefresh.setOnRefreshListener {
            fetchMovies()
        }
    }

    override fun onStart() {
        super.onStart()
        fetchMovies()
    }

    private fun fetchMovies() {
        nowPlayingMovieRelay.onNext(1)
    }

    override fun createPresenter(): MovieListPresenter {
        return mPresenter
    }

    override fun render(viewState: MovieListViewState) {
        when (viewState) {
            is MovieListViewState.Progress -> {
                binding.swipeRefresh.isRefreshing = true
            }
            is MovieListViewState.MovieList -> {
                binding.swipeRefresh.isRefreshing = false
                renderMovies(viewState.movies)
            }
            is MovieListViewState.Error -> {
                binding.swipeRefresh.isRefreshing = false
                showToast(viewState.t.localizedMessage)
            }
        }
    }

    private fun renderMovies(movies: List<Movie>) {
        mAdapter.setNewData(movies as MutableList<Movie>)
    }

    override fun nowPlayingMovieListIntent(): Observable<Int> {
        return nowPlayingMovieRelay
    }
}