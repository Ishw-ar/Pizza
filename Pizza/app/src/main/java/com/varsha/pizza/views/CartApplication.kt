package com.varsha.pizza

import android.app.Application
import com.varsha.pizza.local.MyDatabase
import com.varsha.pizza.repository.CartRepository

class CartApplication : Application() {
    private val myDao by lazy {
        val roomDatabase = MyDatabase.getDatabase(this)
        roomDatabase.getMyDao()
    }
    val repository: CartRepository by lazy {
        CartRepository(myDao)
    }
}