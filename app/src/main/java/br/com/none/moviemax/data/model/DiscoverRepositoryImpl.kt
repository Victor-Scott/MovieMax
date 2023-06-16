package br.com.none.moviemax.data.model

import br.com.none.moviemax.data.DiscoverRepository
import br.com.none.moviemax.data.api.DiscoverAPI
import br.com.none.moviemax.domain.model.Movie
import javax.inject.Inject

class DiscoverRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverAPI
) : DiscoverRepository {

    override suspend fun getMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

}