package br.com.none.moviemax.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceProvider {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

}