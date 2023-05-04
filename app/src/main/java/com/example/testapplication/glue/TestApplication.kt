package com.example.testapplication.glue

import android.app.Application
import com.example.authentication.di.component.AuthenticationComponentDependencies
import com.example.authentication.di.component.AuthenticationComponentDependenciesProvider
import com.example.testapplication.di.components.ApplicationComponent
import com.example.testapplication.di.components.DaggerApplicationComponent

class TestApplication : Application(), AuthenticationComponentDependenciesProvider {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    override fun getAuthenticationComponentDependencies(): AuthenticationComponentDependencies =
        applicationComponent


}
