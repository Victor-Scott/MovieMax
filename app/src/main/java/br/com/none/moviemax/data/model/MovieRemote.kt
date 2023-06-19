package br.com.none.moviemax.data.model

import br.com.none.moviemax.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieRemote(
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>?,
    @SerializedName("id") val id: Int,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("popularity") val popularity: Double?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?
)

fun MovieRemote.toDomain() = Movie(
    id = this.id,
    posterPath = this.posterPath,
    title = this.title.orEmpty(),
    voteAverage = this.voteAverage ?: 0.0,
    voteCount = this.voteCount ?: 0
)

data class BasePaginationRemote<out T>(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: T,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)