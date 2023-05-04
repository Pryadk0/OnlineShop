package com.example.authentication.di.modules

import androidx.lifecycle.ViewModel
import com.example.authentication.presentation.login.LogInViewModel
import com.example.authentication.presentation.signin.SignInPageViewModel
import com.example.presentation.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AuthenticationViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignInPageViewModel::class)
    fun bindSignInPageViewModel(impl: SignInPageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LogInViewModel::class)
    fun bindLogInViewModel(impl: LogInViewModel): ViewModel
}