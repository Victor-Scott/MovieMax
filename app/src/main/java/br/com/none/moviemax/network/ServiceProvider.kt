package br.com.none.moviemax.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceProvider {

    private val contentType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    fun <T> createService(apiClass: Class<T>): T = retrofit.create(apiClass)
}