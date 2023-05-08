package com.example.testapplication.glue

import android.app.Application
import com.example.testapplication.features.authentication.di.component.AuthenticationComponentDependencies
import com.example.testapplication.features.authentication.di.component.AuthenticationComponentDependenciesProvider
import com.example.testapplication.features.page1.di.component.Page1ComponentDependencies
import com.example.testapplication.features.page1.di.component.Page1ComponentDependenciesProvider
import com.example.testapplication.features.page2.di.component.Page2ComponentDependencies
import com.example.testapplication.features.page2.di.component.Page2ComponentDependenciesProvider
import com.example.testapplication.features.profile.di.component.ProfileComponentDependencies
import com.example.testapplication.features.profile.di.component.ProfileComponentDependenciesProvider
import com.example.testapplication.di.components.ApplicationComponent
import com.example.testapplication.di.components.DaggerApplicationComponent

class TestApplication : Application(),
    AuthenticationComponentDependenciesProvider,
    Page1ComponentDependenciesProvider,
    Page2ComponentDependenciesProvider,
    ProfileComponentDependenciesProvider {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }

    override fun getAuthenticationComponentDependencies(): AuthenticationComponentDependencies =
        applicationComponent

    override fun getPage1ComponentDependencies(): Page1ComponentDependencies = applicationComponent

    override fun getPage2ComponentDependencies(): Page2ComponentDependencies = applicationComponent
    override fun getProfileComponentDependencies(): ProfileComponentDependencies = applicationComponent

}
