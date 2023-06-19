package br.com.none.moviemax.network

import br.com.none.moviemax.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceProvider {

    private val client by lazy {
        val loggingLevel = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val logging = HttpLoggingInterceptor()
            .setLevel(loggingLevel)

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> createService(apiClass: Class<T>): T = retrofit.create(apiClass)
}