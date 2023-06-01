package com.example.testapplication.di.components

import android.content.Context
import com.example.testapplication.features.authentication.LogInRouter
import com.example.testapplication.features.authentication.SignInRouter
import com.example.testapplication.features.authentication.di.component.AuthenticationComponentDependencies
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import com.example.testapplication.data.database.di.DatabaseModule
import com.example.testapplication.data.network.di.NetworkModule
import com.example.testapplication.features.page1.Page1Router
import com.example.testapplication.features.page1.di.component.Page1ComponentDependencies
import com.example.testapplication.features.page1.domain.Page1Repository
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.features.page2.di.component.Page2ComponentDependencies
import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.features.page2.domain.ProductImageRepository
import com.example.testapplication.features.profile.ProfileRouter
import com.example.testapplication.features.profile.di.component.ProfileComponentDependencies
import com.example.testapplication.glue.authentication.di.AuthenticationModule
import com.example.testapplication.glue.page1.di.Page1Module
import com.example.testapplication.glue.page2.di.Page2Module
import com.example.testapplication.glue.profile.di.ProfileModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class,
        AuthenticationModule::class,
        Page1Module::class,
        Page2Module::class,
        ProfileModule::class
    ]
)
internal interface ApplicationComponent : AuthenticationComponentDependencies, Page1ComponentDependencies,
    Page2ComponentDependencies, ProfileComponentDependencies {

    //AuthenticationComponentDependencies:
    override fun getLogInRouter(): LogInRouter
    override fun getSignInRouter(): SignInRouter
    override fun getAuthenticationRepository(): AuthenticationRepository

    //Page1ComponentDependencies:
    override fun getPage1Router(): Page1Router
    override fun getPage1Repository(): Page1Repository

    //Page2ComponentDependencies:
    override fun getPage2Router(): Page2Router
    override fun getProductImageRepository(): ProductImageRepository
    override fun getPage2Repository(): Page2Repository

    //ProfileComponentDependencies
    override fun getProfileRouter(): ProfileRouter

    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}