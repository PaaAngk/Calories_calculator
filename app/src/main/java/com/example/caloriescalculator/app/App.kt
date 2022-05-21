package com.example.caloriescalculator.app

import android.app.Application
import com.example.caloriescalculator.di.AppComponent
import com.example.caloriescalculator.di.DaggerAppComponent

class App: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }
}