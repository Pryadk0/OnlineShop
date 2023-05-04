package com.example.testapplication.glue.profile.di

import androidx.lifecycle.ViewModel
import com.example.profile.ProfileRouter
import com.example.profile.presentation.ProfileViewModel
import com.example.testapplication.glue.profile.ProfileRouterImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    fun bindProfileViewModel(impl: ProfileViewModel): ViewModel

    @ProfileScope
    @Binds
    fun bindProfileRouter(impl: ProfileRouterImpl): ProfileRouter

}