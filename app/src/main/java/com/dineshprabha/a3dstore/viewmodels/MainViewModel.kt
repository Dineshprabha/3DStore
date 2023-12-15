package com.dineshprabha.a3dstore.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dineshprabha.a3dstore.models.ProductItem
import com.dineshprabha.a3dstore.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (private val repository: ProductRepository,
    private val randomize: Randomize) : ViewModel() {

    val productLiveData : LiveData<List<ProductItem>>
        get() = repository.products

    init {
        viewModelScope.launch {

            repository.getProducts()
        }
    }
}

class Randomize @Inject constructor(){
    fun doAction(){
        Log.d("3DStore", "Random Action")
    }
}