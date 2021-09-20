package com.varsha.pizza.models


import com.google.gson.annotations.SerializedName

data class PizzaResponse(
    @SerializedName("crusts")
    val crusts: List<Crust>?,
    @SerializedName("defaultCrust")
    val defaultCrust: Int?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("isVeg")
    val isVeg: Boolean?,
    @SerializedName("name")
    val name: String?
)