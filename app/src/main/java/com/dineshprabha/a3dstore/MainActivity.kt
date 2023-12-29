package com.dineshprabha.a3dstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dineshprabha.a3dstore.adapter.ProductAdapter
import com.dineshprabha.a3dstore.database.DatabaseHelper
import com.dineshprabha.a3dstore.databinding.ActivityMainBinding
import com.dineshprabha.a3dstore.viewmodels.MainViewModel
import com.dineshprabha.a3dstore.viewmodels.MainViewModelFactory
import com.google.gson.Gson
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var gson: Gson

    @Inject
    lateinit var dbHelper: DatabaseHelper

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private var productAdapter= ProductAdapter()

//    private val products: TextView
//        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as FakerApplications).applicationComponent.inject(this)
        val map = (application as FakerApplications).applicationComponent.getMap()

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        productAdapter = ProductAdapter()

        setupRecyclerView()
        setupObserver()

    }

    private fun setupObserver() {
        mainViewModel.productLiveData.observe(this, Observer {productList ->
            if (productList != null){
                productAdapter.setProductList(productList)
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.VISIBLE
            }

        })
    }

    private fun setupRecyclerView() {
        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = productAdapter
        }
    }
}