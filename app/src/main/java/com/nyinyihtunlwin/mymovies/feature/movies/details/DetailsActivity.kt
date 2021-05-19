package com.nyinyihtunlwin.mymovies.feature.movies.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.nyinyihtunlwin.domain.model.movie.Movie
import com.nyinyihtunlwin.domain.viewstate.MovieDetailsViewState
import com.nyinyihtunlwin.mymovies.databinding.ActivityDetailsBinding
import com.nyinyihtunlwin.mymovies.feature.base.BaseMviActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.koin.android.ext.android.inject

class DetailsActivity :
    BaseMviActivity<MovieDetailsViewState, MovieDetailsView, MovieDetailsPresenter>(),
    MovieDetailsView {

    companion object {
        fun newInstance(context: Context, id: Int): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("movie-id", id)
            return intent
        }
    }

    private var movieId: Int = 0
    private lateinit var binding: ActivityDetailsBinding

    private val mPresenter: MovieDetailsPresenter by inject()
    private val movieDetailsRelay: PublishSubject<Int> = PublishSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (intent.hasExtra("movie-id")) {
            movieId = intent.getIntExtra("movie-id", 0)
        }
    }

    override fun onStart() {
        super.onStart()
        fetchDetails(movieId)
    }

    private fun fetchDetails(movieId: Int) {
        movieDetailsRelay.onNext(movieId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun createPresenter(): MovieDetailsPresenter {
        return mPresenter
    }

    override fun render(viewState: MovieDetailsViewState) {
        when (viewState) {
            is MovieDetailsViewState.Progress -> {
                showLoading()
            }
            is MovieDetailsViewState.MovieDetails -> {
                hideLoading()
                renderMovieDetails(viewState.movie)
            }
            is MovieDetailsViewState.Error -> {
                hideLoading()
                showToast(viewState.t.localizedMessage)
            }
        }
    }

    private fun renderMovieDetails(movie: Movie) {
        Glide.with(binding.root.context)
            .load(movie.backdropPath)
            .into(binding.ivBackgroundPoster)
        Glide.with(binding.root.context)
            .load(movie.posterPath)
            .into(binding.ivMovie)
        binding.tvTitle.text = movie.title
        binding.tvOverview.text = movie.overview
        binding.tvReleaseDate.text = movie.releaseDate
    }

    override fun movieDetailsIntent(): Observable<Int> {
        return movieDetailsRelay
    }
}