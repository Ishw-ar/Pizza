package com.varsha.pizza.api

import com.varsha.pizza.models.PizzaResponse
import retrofit2.Response
import retrofit2.http.GET




interface PizzaApiService {
    @GET("Ishw-ar/d0b862eb30cb79395560137777a73468/raw/9bb91f4dd9ff8432e69c283f616af64895fcf7bb/api.json")
    suspend fun getPizza():Response<PizzaResponse>
}