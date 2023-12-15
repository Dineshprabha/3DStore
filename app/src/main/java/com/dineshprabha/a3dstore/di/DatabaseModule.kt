package com.dineshprabha.a3dstore.di

import android.content.Context
import androidx.room.Room
import com.dineshprabha.a3dstore.database.DatabaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDBHelper(context: Context) : DatabaseHelper{
        return Room.databaseBuilder(context, DatabaseHelper::class.java, "StoreDB").build()
    }
}