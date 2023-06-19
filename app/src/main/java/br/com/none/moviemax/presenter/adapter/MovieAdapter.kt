package br.com.none.moviemax.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.none.moviemax.databinding.MovieItemBinding
import br.com.none.moviemax.presenter.model.MovieViewObject
import coil.load

class MovieAdapter(
    private val movies: List<MovieViewObject>
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}

class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieViewObject) = with(binding) {
        movieItemName.text = movie.title
        movieItemInfo.text = "${movie.voteAverage} / ${movie.voteCount}"
        movie.posterPath?.let { poster ->
            movieItemPoster.load(basePosterUrl + poster)
        }
    }

    companion object {
        private const val basePosterUrl = "https://image.tmdb.org/t/p/w500/"
    }
}
