package com.varsha.pizza.repository

import androidx.lifecycle.LiveData
import com.varsha.pizza.local.MyDao
import com.varsha.pizza.local.MyEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartRepository(private val myDao: MyDao) {

  fun addItems(myEntity: MyEntity){
      CoroutineScope(Dispatchers.IO).launch {
          myDao.insertItems(myEntity)
      }

  }
    fun getItems():LiveData<List<MyEntity>>{
       return myDao.getItems()
    }

}