package com.example.testapplication.glue.profile.di

import com.example.profile.ProfileRouter
import com.example.profile.di.scopes.ProfileFeatureScope
import com.example.testapplication.glue.profile.ProfileRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface ProfileModule {

    @ProfileFeatureScope
    @Binds
    fun bindProfileRouter(impl: ProfileRouterImpl): ProfileRouter
}