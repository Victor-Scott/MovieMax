package br.com.none.moviemax.presenter.model

import br.com.none.moviemax.domain.model.Movie

data class MovieViewObject(
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int

) {
    constructor(movie: Movie) : this(
        title = movie.title,
        posterPath = movie.posterPath,
        voteAverage = movie.voteAverage,
        voteCount = movie.voteCount
    )
}
