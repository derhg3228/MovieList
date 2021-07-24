package com.example.movielist.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.R
import com.example.movielist.model.MovieModel
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movieList: MutableList<MovieModel>
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var posterView: ImageView = view.findViewById(R.id.poster)
        var titleView: TextView = view.findViewById(R.id.title)
        var descriptionView: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.titleView.text = movieList[position].title
        holder.descriptionView.text = movieList[position].description
        Picasso.get()
            .load("https:${movieList[position].poster}")
            .fit()
            .into(holder.posterView)
    }

    override fun getItemCount() = movieList.size

    fun addMovies(movies: List<MovieModel>) {
        movieList.addAll(movies)
        notifyDataSetChanged()
    }
}