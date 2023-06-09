package com.example.testapplication.features.page1.di.modules

import androidx.lifecycle.ViewModel
import com.example.testapplication.core.presentation.viewmodel.ViewModelKey
import com.example.testapplication.features.page1.presentation.Page1ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface Page1ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(Page1ViewModel::class)
    fun bindSignInPageViewModel(impl: Page1ViewModel): ViewModel
}