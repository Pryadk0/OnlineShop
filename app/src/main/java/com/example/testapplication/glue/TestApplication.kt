package com.example.testapplication.glue

import android.app.Application
import com.example.authentication.di.component.AuthenticationComponentDependencies
import com.example.authentication.di.component.AuthenticationComponentDependenciesProvider
import com.example.page1.di.component.Page1ComponentDependencies
import com.example.page1.di.component.Page1ComponentDependenciesProvider
import com.example.page2.di.component.Page2ComponentDependencies
import com.example.page2.di.component.Page2ComponentDependenciesProvider
import com.example.profile.di.component.ProfileComponentDependencies
import com.example.profile.di.component.ProfileComponentDependenciesProvider
import com.example.testapplication.di.components.ApplicationComponent

class TestApplication : Application(),
    AuthenticationComponentDependenciesProvider,
    Page1ComponentDependenciesProvider,
    Page2ComponentDependenciesProvider,
    ProfileComponentDependenciesProvider {

    lateinit var applicationComponent: ApplicationComponent

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
