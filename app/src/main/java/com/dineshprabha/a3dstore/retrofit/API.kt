package com.dineshprabha.a3dstore.retrofit

import com.dineshprabha.a3dstore.models.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductItem>>
}