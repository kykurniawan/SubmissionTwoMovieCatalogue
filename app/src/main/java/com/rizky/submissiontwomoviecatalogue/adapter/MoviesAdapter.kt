package com.rizky.submissiontwomoviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rizky.submissiontwomoviecatalogue.R
import com.rizky.submissiontwomoviecatalogue.model.Movies
import kotlinx.android.synthetic.main.item_row_movies.view.*

class MoviesAdapter(private val listMovie: ArrayList<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: Movies) {
            with(itemView) {
                img_movies_poster.setImageResource(movies.moviePoster)
                tv_movies_title.text = movies.movieTitle
                tv_movies_description.text = movies.movieDescription
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(movies) }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_movies, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Movies)
    }

}