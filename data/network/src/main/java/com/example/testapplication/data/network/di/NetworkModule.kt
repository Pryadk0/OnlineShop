package com.example.testapplication.data.network.di

import com.example.testapplication.data.network.ApiFactory
import com.example.testapplication.data.network.ApiService
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