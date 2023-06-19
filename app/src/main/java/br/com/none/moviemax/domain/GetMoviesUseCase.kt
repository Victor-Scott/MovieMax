package br.com.none.moviemax.domain

import br.com.none.moviemax.data.DiscoverRepository
import br.com.none.moviemax.domain.model.Movie
import javax.inject.Inject

interface GetMoviesUseCase {
    suspend operator fun invoke(): Result<List<Movie>>
}

class GetMoviesUseCaseImpl @Inject constructor(
    private val repository: DiscoverRepository
) : GetMoviesUseCase {

    override suspend fun invoke() = runCatching { repository.getMovies() }
}