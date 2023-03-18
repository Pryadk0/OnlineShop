package com.example.testapplication.di.components

import android.content.Context
import com.example.testapplication.di.modules.DataModule
import com.example.testapplication.di.modules.DomainModule
import com.example.testapplication.di.modules.ViewModelModule
import com.example.testapplication.di.scopes.ApplicationScope
import com.example.testapplication.presentation.fragments.*
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(logInFragment: LogInFragment)

    fun inject(page1Fragment: Page1Fragment)

    fun inject(signInPageFragment: SignInPageFragment)

    fun inject(productImageFragment: ProductImageFragment)

    fun inject(page2Fragment: Page2Fragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}