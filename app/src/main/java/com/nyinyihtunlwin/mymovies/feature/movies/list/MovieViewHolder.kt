package com.nyinyihtunlwin.mymovies.feature.movies.list

import android.view.View
import com.bumptech.glide.Glide
import com.nyinyihtunlwin.domain.model.movie.Movie
import com.nyinyihtunlwin.mymovies.databinding.ViewItemMovieBinding
import com.nyinyihtunlwin.mymovies.feature.base.BaseViewHolder

class MovieViewHolder(
    val binding: ViewItemMovieBinding,
    var movieDelegate: MovieDelegate
) : BaseViewHolder<Movie>(binding.root) {

    override fun setData(data: Movie) {
        mData = data
        Glide.with(binding.root.context)
            .load(mData?.posterPath)
            .into(binding.ivMovie)
    }

    override fun onClick(v: View?) {
        movieDelegate.onTapMovie(mData!!)
    }
}