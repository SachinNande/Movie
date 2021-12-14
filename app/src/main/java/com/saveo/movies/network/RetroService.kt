package com.saveo.movies.network

import com.saveo.movies.model.MovieDetail
import retrofit2.http.GET

interface RetroService {

    @GET("posts")
    suspend fun getDataFromApi(): MovieDetail
}