package com.rizky.submissiontwomoviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.model.TvShow
import kotlinx.android.synthetic.main.item_row_tv_show.view.*

class TvShowAdapter(private val listTvShow: ArrayList<TvShow>) :
    RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tvShow: TvShow) {
            with(itemView) {
                img_tv_show_poster.setImageResource(tvShow.tvShowPoster)
                tv_tv_show_title.text = tvShow.tvShowTitle
                tv_tv_show_description.text = tvShow.tvShowDescription
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(tvShow) }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_tv_show, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listTvShow.size

    interface OnItemClickCallback {
        fun onItemClicked(data: TvShow)
    }

}