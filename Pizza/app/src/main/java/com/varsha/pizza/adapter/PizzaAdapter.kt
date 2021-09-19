package com.varsha.pizza.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.varsha.pizza.R
import com.varsha.pizza.models.Crust
import kotlinx.android.synthetic.main.pizza_item_layout.view.*

class PizzaAdapter(var PizzaList: List<Crust>) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_layout, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val currentPizzaList = PizzaList[position]
        var sizePrice = 0.0
        holder.itemView.apply {
            text_pizza_title.text = currentPizzaList.name
            // text_pizza_description.text=currentPizzaList.description
        }
        holder.itemView.apply {
            val sizeArray = arrayOf("Regular", "Medium", "Large")
            val crustArray = arrayOf("Hand-tossed", "Cheese Burst")


            sp_size.adapter =
                ArrayAdapter<String>(
                    context,
                    android.R.layout.simple_spinner_dropdown_item,
                    sizeArray
                )
            sp_crust.adapter = ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                crustArray
            )

            sp_size.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    @SuppressLint("SetTextI18n")
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        when {
                            sizeArray[position] == "Regular" -> {
                                sizePrice = currentPizzaList.sizes?.get(position)?.price!!

                                text_price.text =
                                    "₹ $sizePrice"


                            }
                            sizeArray[position] == "Medium" -> {
                                sizePrice = currentPizzaList.sizes?.get(position)?.price!!
                                text_price.text =
                                    "₹ $sizePrice"
                            }
                            sizeArray[position] == "Large" -> {
                                sizePrice = currentPizzaList.sizes?.get(position)?.price!!

                                text_price.text =
                                    "₹ $sizePrice"


                            }
                        }


                    }

                    @SuppressLint("SetTextI18n")
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        text_price.text = "₹ 199"
                    }

                }
            sp_crust.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    @SuppressLint("SetTextI18n")
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        when {
                            crustArray[position] == "Hand-tossed" -> {

                                val crustPrice = 100.00
                                val finalPrice = crustPrice + sizePrice
                                text_price.text =
                                    "₹ $finalPrice"
                            }
                            crustArray[position] == "Cheese Burst" -> {
                                val crustPrice = 120.00
                                val finalPrice = crustPrice + sizePrice
                                text_price.text =
                                    "₹ $finalPrice"
                            }

                        }


                    }

                    @SuppressLint("SetTextI18n")
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        text_price.text = "₹ 199"
                    }

                }
        }
    }

    override fun getItemCount() = PizzaList.size

}