package br.com.none.moviemax.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.none.moviemax.databinding.MovieItemBinding
import br.com.none.moviemax.presenter.model.MovieViewObject
import coil.load

private const val basePosterUrl = "https://image.tmdb.org/t/p/w500/"

class MovieAdapter(
    private val movies: List<MovieViewObject>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val movieName = binding.movieItemName
        val poster = binding.movieItemPoster
        val voteCount = binding.movieItemVoteCount
        val voteAverage = binding.movieItemVoteAverage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MovieViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.apply {
            movieName.text = movie.title
            poster.load(
                basePosterUrl + movie.posterPath
            )

        }
    }

}
