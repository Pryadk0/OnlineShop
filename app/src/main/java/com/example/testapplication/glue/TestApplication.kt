package com.example.testapplication.glue

import android.app.Application
import com.example.testapplication.di.components.DaggerApplicationComponent

class TestApplication : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }


}