package com.varsha.pizza.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varsha.pizza.models.PizzaResponse
import com.varsha.pizza.repository.PizzaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel(val repository: PizzaRepository):ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getPizza()
        }
    }
    val pizzas: LiveData<PizzaResponse>
    get() = repository.pizzas


}