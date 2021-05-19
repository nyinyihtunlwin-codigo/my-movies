package com.nyinyihtunlwin.mymovies.feature.movies.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nyinyihtunlwin.domain.model.movie.Movie
import com.nyinyihtunlwin.mymovies.databinding.ViewItemMovieBinding
import com.nyinyihtunlwin.mymovies.feature.base.BaseRecyclerAdapter
import com.nyinyihtunlwin.mymovies.feature.base.BaseViewHolder

class MovieAdapter(context: Context, var movieDelegate: MovieDelegate) :
    BaseRecyclerAdapter<MovieViewHolder, Movie>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> {
        val binding =
            ViewItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding, movieDelegate)
    }
}