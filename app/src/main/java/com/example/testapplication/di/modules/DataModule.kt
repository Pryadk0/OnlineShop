package com.example.testapplication.di.modules

import android.content.Context
import com.example.testapplication.data.database.UsersDao
import com.example.testapplication.data.database.UsersDatabase
import com.example.testapplication.data.datasource.local.LocalDataSource
import com.example.testapplication.data.datasource.local.LocalDataSourceImpl
import com.example.testapplication.data.datasource.remote.RemoteDataSource
import com.example.testapplication.data.datasource.remote.RemoteDataSourceImpl
import com.example.testapplication.data.network.ApiFactory
import com.example.testapplication.data.network.ApiService
import com.example.testapplication.di.scopes.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindsLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @ApplicationScope
    @Binds
    fun bindsRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService = ApiFactory.getApiService()

        @ApplicationScope
        @Provides
        fun provideUsersDao(context: Context): UsersDao =
            UsersDatabase.getInstance(context).usersDao()

    }


}