package com.varsha.pizza.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.varsha.pizza.api.PizzaApiService
import com.varsha.pizza.models.PizzaResponse

class PizzaRepository(private val pizzaApiService: PizzaApiService) {
    private val pizzaLiveData=MutableLiveData<PizzaResponse>()

    val pizzas:LiveData<PizzaResponse>
    get() = pizzaLiveData


    suspend fun getPizza(){
        val result= pizzaApiService.getPizza()
        if (result?.body()!=null){
            pizzaLiveData.postValue(result.body())

        }
    }
}