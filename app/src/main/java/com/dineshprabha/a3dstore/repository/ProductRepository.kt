package com.dineshprabha.a3dstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dineshprabha.a3dstore.database.DatabaseHelper
import com.dineshprabha.a3dstore.models.ProductItem
import com.dineshprabha.a3dstore.retrofit.API
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api: API,
    private val dbHelper : DatabaseHelper) {

    private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>>

        get() = _products

    suspend fun getProducts(){
        val result = api.getProducts()

        if (result.isSuccessful && result.body() != null){
            dbHelper.getProductDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}