package com.example.testapplication.di.modules

import androidx.lifecycle.ViewModel
import com.example.testapplication.di.keys.ViewModelKey
import com.example.testapplication.presentation.viewmodels.AuthenticationViewModel
import com.example.testapplication.presentation.viewmodels.AuthorizedViewModel
import com.example.testapplication.presentation.viewmodels.DetailProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthenticationViewModel::class)
    fun bindAuthenticationViewModel(impl: AuthenticationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizedViewModel::class)
    fun bindAuthorizedViewModel(impl: AuthorizedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailProductViewModel::class)
    fun bindDetailProductViewModel(impl: DetailProductViewModel): ViewModel


}