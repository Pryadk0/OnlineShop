package com.example.profile.di.modules

import androidx.lifecycle.ViewModel
import com.example.presentation.viewmodel.ViewModelKey
import com.example.profile.presentation.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindPage2ViewModel(impl: ProfileViewModel): ViewModel

}