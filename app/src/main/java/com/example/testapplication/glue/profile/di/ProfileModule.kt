package com.example.testapplication.glue.profile.di

import com.example.testapplication.features.profile.ProfileRouter
import com.example.testapplication.glue.profile.ProfileRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface ProfileModule {

    @Binds
    fun bindProfileRouter(impl: ProfileRouterImpl): ProfileRouter
}