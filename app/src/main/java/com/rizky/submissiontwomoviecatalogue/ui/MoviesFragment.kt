package com.rizky.submissiontwomoviecatalogue.ui


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.adapter.MoviesAdapter
import com.rizky.submissiontwomoviecatalogue.model.Movies
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {
    private val list = ArrayList<Movies>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Movies>()

        rv_movies.setHasFixedSize(true)
        list.addAll(getListMovies())
        rv_movies.layoutManager = LinearLayoutManager(activity)
        val listMoviesAdapter = MoviesAdapter(list)
        rv_movies.adapter = listMoviesAdapter

        listMoviesAdapter.setOnItemClickCallback(object : MoviesAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movies) {
                showSelectedMovie(data)
            }
        })
    }

    @SuppressLint("Recycle")
    private fun getListMovies(): ArrayList<Movies> {
        val dataTitle = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPoster = resources.obtainTypedArray(R.array.data_photo)
        val dataRelease = resources.getStringArray(R.array.data_release)
        val dataDirector = resources.getStringArray(R.array.data_director)
        val listMovies = ArrayList<Movies>()
        for (position in dataTitle.indices) {
            val movies = Movies(
                dataTitle[position],
                dataDescription[position],
                dataPoster.getResourceId(position, -1),
                dataRelease[position],
                dataDirector[position]
            )
            listMovies.add(movies)
        }
        return listMovies
    }

    private fun showSelectedMovie(movies: Movies) {
        val mIntent = Intent(activity, MoviesDetailActivity::class.java)
        mIntent.putExtra(MoviesDetailActivity.EXTRA_MOVIE, movies)
        startActivity(mIntent)
    }

}
