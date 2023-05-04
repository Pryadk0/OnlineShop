package com.example.network.di

import com.example.network.ApiFactory
import com.example.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NetworkModule {

    companion object {

        @Singleton
        @Provides
        fun provideApiService(): ApiService = ApiFactory.getApiService()
    }
}