package com.varsha.pizza.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.varsha.pizza.CartApplication
import com.varsha.pizza.R
import com.varsha.pizza.adapter.PizzaAdapter
import com.varsha.pizza.api.PizzaApiService
import com.varsha.pizza.api.RetrofitHelper
import com.varsha.pizza.interfaces.ItemListener
import com.varsha.pizza.local.MyEntity
import com.varsha.pizza.models.Crust
import com.varsha.pizza.repository.PizzaRepository
import com.varsha.pizza.viewmodels.CartViewModel
import com.varsha.pizza.viewmodels.CartViewModelFactory
import com.varsha.pizza.viewmodels.PizzaViewModel
import com.varsha.pizza.viewmodels.PizzaViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemListener {

    lateinit var pizzaViewModel: PizzaViewModel
    lateinit var pizzaAdapter: PizzaAdapter
    private val pizzaResponse = mutableListOf<Crust>()
    private lateinit var viewModel: CartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizzaAdapter = PizzaAdapter(pizzaResponse,this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = pizzaAdapter

        val pizzaApiService = RetrofitHelper.getInstance().create(PizzaApiService::class.java)
        val repository = PizzaRepository(pizzaApiService)

        pizzaViewModel = ViewModelProvider(
            this,
            PizzaViewModelFactory(repository)
        ).get(PizzaViewModel::class.java)
        pizzaViewModel.pizzas.observe(this, Observer {
            pizzaAdapter.PizzaList = it.crusts!!

            pizzaAdapter.notifyDataSetChanged()
        })

        val appObj = application as CartApplication
        val cartRepository = appObj.repository
        val viewModelFactory = CartViewModelFactory(cartRepository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CartViewModel::class.java)

        button_cart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    override fun addCartItems(name: String, size: String, crust: String, price: Double) {
        val myEntity = MyEntity(name, size, crust, price)
        viewModel.addItems(myEntity)
    }
    }
