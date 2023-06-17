package br.com.none.moviemax.data.model

import br.com.none.moviemax.BuildConfig
import br.com.none.moviemax.data.DiscoverRepository
import br.com.none.moviemax.data.api.DiscoverAPI
import br.com.none.moviemax.domain.model.Movie
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverAPI
) : DiscoverRepository {

    override suspend fun getMovies(): List<Movie> {
        return try {
            discoverService.getMovies(BuildConfig.tmdbToken).results.map {
                it.toDomain()
            }
        } catch (e: Exception) {
            throw DiscoverRepositoryException()
        }
    }
}

class DiscoverRepositoryException : Exception() {

}
