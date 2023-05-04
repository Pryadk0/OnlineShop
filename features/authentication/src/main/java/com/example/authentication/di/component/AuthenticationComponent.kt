package com.example.authentication.di.component

import androidx.lifecycle.ViewModel
import com.example.authentication.di.modules.AuthenticationViewModelModule
import com.example.authentication.di.scopes.AuthenticationFeatureScope
import com.example.authentication.presentation.login.LogInFragment
import com.example.authentication.presentation.signin.SignInPageFragment
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