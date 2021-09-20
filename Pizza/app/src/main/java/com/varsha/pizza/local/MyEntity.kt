package com.varsha.pizza.local

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * This is the structure of our table in the database
 */
@Entity(tableName = "my_cart_table")
data class MyEntity(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "crust") val crust: String,
    @ColumnInfo(name = "price") val price: Double
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}