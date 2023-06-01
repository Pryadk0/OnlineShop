package com.example.testapplication.features.authentication.di.modules

import androidx.lifecycle.ViewModel
import com.example.testapplication.core.presentation.viewmodel.ViewModelKey
import com.example.testapplication.features.authentication.presentation.login.LogInViewModel
import com.example.testapplication.features.authentication.presentation.signin.SignInPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface AuthenticationViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInPageViewModel::class)
    fun bindSignInPageViewModel(impl: SignInPageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LogInViewModel::class)
    fun bindLogInViewModel(impl: LogInViewModel): ViewModel
}