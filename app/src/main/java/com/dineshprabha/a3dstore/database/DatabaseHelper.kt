package com.dineshprabha.a3dstore.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dineshprabha.a3dstore.models.ProductItem

@Database(entities = [ProductItem::class], version = 1)
abstract class DatabaseHelper : RoomDatabase(){

    abstract fun getProductDao() : ProductDao


}