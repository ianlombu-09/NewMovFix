package com.lexical.newmovfix.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lexical.newmovfix.R
import com.lexical.newmovfix.data.model.MovieModel
import com.lexical.newmovfix.data.model.MoviePopularResponse
import kotlinx.android.synthetic.main.recycler_popular_movie.view.*

class HomeAdapter(
        private val movies: ArrayList<MovieModel>
        ): RecyclerView.Adapter<HomeAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: MovieModel) {
            itemView.movie_title.text = movies.title
            Glide.with(itemView.movie_img.context)
                    .load(movies.poster_path)
                    .into(itemView.movie_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder (
                LayoutInflater.from(parent.context).inflate(
                        R.layout.recycler_popular_movie, parent, false
                )
            )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(movies[position])

    fun addData(list: List<MovieModel>) {
        movies.addAll(list)
    }
}