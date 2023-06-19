package br.com.none.moviemax.domain.model

data class Movie(
    val id: Int,
    val posterPath: String?,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)
