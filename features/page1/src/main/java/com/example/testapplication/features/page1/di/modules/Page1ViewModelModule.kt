package com.example.testapplication.features.page1.di.modules

import androidx.lifecycle.ViewModel
import com.example.testapplication.features.page1.presentation.Page1ViewModel
import com.example.presentation.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface Page1ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(Page1ViewModel::class)
    fun bindSignInPageViewModel(impl: Page1ViewModel): ViewModel
}