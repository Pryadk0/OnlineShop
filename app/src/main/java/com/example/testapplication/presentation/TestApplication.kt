package com.example.testapplication.presentation

import android.app.Application
import com.example.testapplication.di.components.DaggerApplicationComponent

class TestApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }


}