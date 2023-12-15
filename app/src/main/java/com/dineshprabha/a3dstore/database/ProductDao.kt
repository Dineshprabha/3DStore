package com.dineshprabha.a3dstore.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dineshprabha.a3dstore.models.ProductItem

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<ProductItem>)

    @Query("SELECT * FROM ProductItem")
    suspend fun getProducts() : List<ProductItem>
}