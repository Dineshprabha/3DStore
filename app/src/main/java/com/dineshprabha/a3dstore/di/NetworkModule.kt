package com.dineshprabha.a3dstore.di

import com.dineshprabha.a3dstore.retrofit.API
import com.dineshprabha.a3dstore.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providedAPI(retrofit: Retrofit) : API{
        return retrofit.create(API::class.java)
    }
}