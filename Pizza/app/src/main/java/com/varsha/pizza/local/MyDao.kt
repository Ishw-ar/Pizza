package com.varsha.pizza.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDao {

    /**
     * This function will insert all the items in the Database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(myEntity: MyEntity)

    /**
     * This function will return all the items from the Database
     */
    @Query("select * from my_cart_table")
    fun getItems(): LiveData<List<MyEntity>>

    /**
     * This function will return  the total number of row from database table
     */
    @Query("SELECT COUNT(*) FROM my_cart_table")
    fun count(): Int


}