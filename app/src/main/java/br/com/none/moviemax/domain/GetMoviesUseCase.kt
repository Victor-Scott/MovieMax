package br.com.none.moviemax.domain

import br.com.none.moviemax.data.DiscoverRepository
import br.com.none.moviemax.domain.model.Movie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: DiscoverRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return try {
            Result.success(repository.getMovies())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}