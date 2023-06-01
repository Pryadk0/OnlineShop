package com.example.testapplication.features.page2.di.modules

import androidx.lifecycle.ViewModel
import com.example.testapplication.core.presentation.viewmodel.ViewModelKey
import com.example.testapplication.features.page2.presentation.page2.Page2ViewModel
import com.example.testapplication.features.page2.presentation.productimage.ProductImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface Page2ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(Page2ViewModel::class)
    fun bindPage2ViewModel(impl: Page2ViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductImageViewModel::class)
    fun bindProductImageViewModel(impl: ProductImageViewModel): ViewModel

}