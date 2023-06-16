package br.com.none.moviemax.data

import br.com.none.moviemax.domain.model.Movie


interface DiscoverRepository {

    suspend fun getMovies(): List<Movie>
}