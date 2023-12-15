package com.dineshprabha.a3dstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dineshprabha.a3dstore.database.DatabaseHelper
import com.dineshprabha.a3dstore.viewmodels.MainViewModel
import com.dineshprabha.a3dstore.viewmodels.MainViewModelFactory
import com.google.gson.Gson
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var gson: Gson

    @Inject
    lateinit var dbHelper: DatabaseHelper

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
        get() = findViewById(R.id.products)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplications).applicationComponent.inject(this)

        val map = (application as FakerApplications).applicationComponent.getMap()

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {
            products.text = it.joinToString { x -> x.title + "\n\n" }

//            Log.i("3DStore", gson.toJson(it))
        })
    }
}