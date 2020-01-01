package com.rizky.submissiontwomoviecatalogue.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.adapter.TvShowAdapter
import com.rizky.submissiontwomoviecatalogue.model.TvShow
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {
    private val list = ArrayList<TvShow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<TvShow>()

        rv_tv_show.setHasFixedSize(true)
        list.addAll(getListTvShow())
        rv_tv_show.layoutManager = LinearLayoutManager(activity)
        val listTvShowAdapter = TvShowAdapter(list)
        rv_tv_show.adapter = listTvShowAdapter

        listTvShowAdapter.setOnItemClickCallback(object : TvShowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TvShow) {
                showSelectedTvShow(data)
            }
        })
    }

    @SuppressLint("Recycle")
    private fun getListTvShow(): ArrayList<TvShow> {
        val dataTitle = resources.getStringArray(R.array.data_tvShow_title)
        val dataDescription = resources.getStringArray(R.array.data_tvShow_description)
        val dataPoster = resources.obtainTypedArray(R.array.data_tvShow_poster)
        val dataSeason = resources.getStringArray(R.array.data_tvShow_season)
        val listTvShow = ArrayList<TvShow>()
        for (position in dataTitle.indices) {
            val tvShow = TvShow(
                dataTitle[position],
                dataDescription[position],
                dataPoster.getResourceId(position, -1),
                dataSeason[position])
            listTvShow.add(tvShow)
        }
        return listTvShow
    }

    private fun showSelectedTvShow(tvShow: TvShow) {
        val mIntent = Intent(activity, TvShowDetailActivity::class.java)
        mIntent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow)
        startActivity(mIntent)
    }


}
