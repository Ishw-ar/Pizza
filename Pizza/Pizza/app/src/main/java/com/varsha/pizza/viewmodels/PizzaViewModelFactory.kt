package com.varsha.pizza.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.varsha.pizza.repository.PizzaRepository

class PizzaViewModelFactory(private val repository: PizzaRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PizzaViewModel(repository) as T
    }
}