package com.nyinyihtunlwin.mymovies.feature.movies.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.nyinyihtunlwin.mymovies.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context, id: Int): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("movie-id", id)
            return intent
        }
    }

    private var movieId: Int = 0
    private lateinit var binding: ActivityDetailsBinding

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}