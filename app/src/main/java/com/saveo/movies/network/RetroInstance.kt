package com.saveo.movies.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BaseURl ="https://jsonplaceholder.typicode.com/"

        fun getRetroInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BaseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}