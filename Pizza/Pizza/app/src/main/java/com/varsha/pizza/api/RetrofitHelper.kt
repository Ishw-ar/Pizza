package com.varsha.pizza.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The ApiServices class is responsible for making the api call by using Retrofit
 */
object RetrofitHelper {
    const val BASE_URL="https://gist.githubusercontent.com/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}