package com.varsha.pizza.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.varsha.pizza.R
import com.varsha.pizza.models.Crust
import com.varsha.pizza.models.PizzaResponse
import kotlinx.android.synthetic.main.pizza_item_layout.view.*

class PizzaAdapter(var PizzaList: List<Crust>) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.pizza_item_layout, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val currentPizzaList = PizzaList[position]
        holder.itemView.apply {
            text_pizza_title.text= currentPizzaList.name
           // text_pizza_description.text=currentPizzaList.description
        }
    }

    override fun getItemCount() = PizzaList.size

}