package com.dineshprabha.a3dstore.di

import androidx.lifecycle.ViewModel
import com.dineshprabha.a3dstore.viewmodels.MainViewModel
import com.dineshprabha.a3dstore.viewmodels.RandomizeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @ClassKey(RandomizeViewModel::class)
    @IntoMap
    abstract fun randomizeViewModel(randomizeViewModel: RandomizeViewModel) : ViewModel


}