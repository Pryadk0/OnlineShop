package com.example.testapplication.features.authentication.di.component

import com.example.testapplication.features.authentication.di.modules.AuthenticationUseCaseModule
import com.example.testapplication.features.authentication.di.modules.AuthenticationViewModelModule
import com.example.testapplication.features.authentication.di.scopes.AuthenticationFeatureScope
import com.example.testapplication.features.authentication.presentation.login.LogInFragment
import com.example.testapplication.features.authentication.presentation.signin.SignInPageFragment
import dagger.Component

@AuthenticationFeatureScope
@Component(
    modules = [AuthenticationViewModelModule::class, AuthenticationUseCaseModule::class],
    dependencies = [AuthenticationComponentDependencies::class]
)
internal interface AuthenticationComponent {

    fun injectSignInPageFragment(signInPageFragment: SignInPageFragment)

    fun injectLogInFragment(logInFragment: LogInFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: AuthenticationComponentDependencies): Builder

        fun build(): AuthenticationComponent
    }

}