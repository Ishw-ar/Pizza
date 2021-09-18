package com.varsha.pizza.api

import com.varsha.pizza.models.PizzaResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL="https://gist.githubusercontent.com/"
const val END_POINT="Ishw-ar/d0b862eb30cb79395560137777a73468/raw/9bb91f4dd9ff8432e69c283f616af64895fcf7bb/api.json"


/**
 * The getPost method will return the Response which we are getting from Api
 */
interface PizzaApiInterface{

   @GET(END_POINT)
   suspend fun getAllPizza() : PizzaResponse
}

/**
 * The ApiServices class is responsible for making the api call by using Retrofit
 */
object PizzaApi {
    val instance:PizzaApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = retrofit.create(PizzaApiInterface::class.java)

    }
}