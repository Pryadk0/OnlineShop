package com.example.testapplication.features.authentication.di.component

import com.example.testapplication.features.authentication.di.modules.AuthenticationViewModelModule
import com.example.testapplication.features.authentication.di.scopes.AuthenticationFeatureScope
import com.example.testapplication.features.authentication.presentation.login.LogInFragment
import com.example.testapplication.features.authentication.presentation.signin.SignInPageFragment
import dagger.Component

@AuthenticationFeatureScope
@Component(
    modules = [AuthenticationViewModelModule::class],
    dependencies = [AuthenticationComponentDependencies::class]
)
interface AuthenticationComponent {

    fun injectSignInPageFragment(signInPageFragment: SignInPageFragment)

    fun injectLogInFragment(logInFragment: LogInFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: AuthenticationComponentDependencies): Builder

        fun build(): AuthenticationComponent
    }

}