package com.varsha.pizza.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.varsha.pizza.R
import com.varsha.pizza.local.MyEntity
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter(var cartList: List<MyEntity>) : RecyclerView.Adapter<CartAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return PizzaViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val currentCartList = cartList[position]
        holder.itemView.apply {
            pizza_name.text=currentCartList.title
            pizza_size.text=currentCartList.size
            pizza_crust.text=currentCartList.crust
            pizza_price.text="₹ "+currentCartList.price.toString()
        }
    }


    override fun getItemCount() = cartList.size

}