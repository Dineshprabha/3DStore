package com.dineshprabha.a3dstore.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RandomizeViewModel @Inject constructor (private val randomize: Randomize): ViewModel() {

    init {
        randomize.doAction()
    }
}