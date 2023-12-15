package com.dineshprabha.a3dstore

import android.app.Application
import com.dineshprabha.a3dstore.di.ApplicationComponent
import com.dineshprabha.a3dstore.di.DaggerApplicationComponent

class FakerApplications : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
            applicationComponent = DaggerApplicationComponent.factory().create(this)

    }
}