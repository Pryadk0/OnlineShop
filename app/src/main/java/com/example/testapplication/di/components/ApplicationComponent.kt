package com.example.testapplication.di.components

import android.content.Context
import com.example.authentication.LogInRouter
import com.example.authentication.SignInRouter
import com.example.authentication.di.component.AuthenticationComponentDependencies
import com.example.authentication.domain.AuthenticationRepository
import com.example.database.di.DatabaseModule
import com.example.testapplication.glue.authentication.di.AuthenticationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        AuthenticationModule::class
    ]
)
interface ApplicationComponent: AuthenticationComponentDependencies {

    override fun getLogInRouterImpl(): LogInRouter

    override fun getSignInRouterImpl(): SignInRouter

    override fun getAuthenticationRepository(): AuthenticationRepository


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}