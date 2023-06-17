package br.com.none.moviemax.data.api

import br.com.none.moviemax.data.model.BasePaginationRemote
import br.com.none.moviemax.data.model.MovieRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverAPI {

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") token: String): BasePaginationRemote<List<MovieRemote>>
}