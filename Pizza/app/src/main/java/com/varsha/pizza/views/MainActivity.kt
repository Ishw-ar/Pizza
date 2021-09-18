package com.varsha.pizza.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.pizza.R
import com.varsha.pizza.adapter.PizzaAdapter
import com.varsha.pizza.api.PizzaApiService
import com.varsha.pizza.api.RetrofitHelper
import com.varsha.pizza.models.Crust
import com.varsha.pizza.models.PizzaResponse
import com.varsha.pizza.repository.PizzaRepository
import com.varsha.pizza.viewmodels.PizzaViewModel
import com.varsha.pizza.viewmodels.PizzaViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var pizzaViewModel: PizzaViewModel
    lateinit var pizzaAdapter: PizzaAdapter
    private val pizzaResponse = mutableListOf<Crust>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizzaAdapter = PizzaAdapter(pizzaResponse)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = pizzaAdapter

        val pizzaApiService=RetrofitHelper.getInstance().create(PizzaApiService::class.java)
        val repository= PizzaRepository(pizzaApiService)

        pizzaViewModel=ViewModelProvider(this, PizzaViewModelFactory(repository)).get(PizzaViewModel::class.java)
        pizzaViewModel.pizzas.observe(this, Observer {
           pizzaAdapter.PizzaList=it.crusts!!

            pizzaAdapter.notifyDataSetChanged()
        })
    }
}