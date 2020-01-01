package com.rizky.submissiontwomoviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.model.Movies
import kotlinx.android.synthetic.main.activity_detail.*

class MoviesDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movies
        tv_title.text = movie.movieTitle
        tv_release.text = movie.movieRelease
        tv_director.text = movie.movieDirector
        tv_description.text = movie.movieDescription
        imageView.setImageResource(movie.moviePoster)

        val actionbar = supportActionBar
        actionbar?.title = movie.movieTitle
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
