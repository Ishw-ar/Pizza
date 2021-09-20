package com.varsha.pizza.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.varsha.pizza.local.MyEntity
import com.varsha.pizza.repository.CartRepository

class CartViewModel(private val repository: CartRepository) : ViewModel() {

    fun addItems(taskEntity: MyEntity) {
        repository.addItems(taskEntity)
    }

    fun getItems(): LiveData<List<MyEntity>> {
        return repository.getItems()
    }

}