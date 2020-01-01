package com.rizky.submissiontwomoviecatalogue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.model.Movies
import com.rizky.submissiontwomoviecatalogue.model.TvShow
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.imageView
import kotlinx.android.synthetic.main.activity_detail.tv_description
import kotlinx.android.synthetic.main.activity_detail.tv_title
import kotlinx.android.synthetic.main.activity_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        val tvShow = intent.getParcelableExtra(EXTRA_TV_SHOW) as TvShow
        tv_title.text = tvShow.tvShowTitle
        tv_season.text = tvShow.tvShowSeason
        tv_description.text = tvShow.tvShowDescription
        imageView.setImageResource(tvShow.tvShowPoster)

        val actionbar = supportActionBar
            actionbar?.title = tvShow.tvShowTitle
            actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
