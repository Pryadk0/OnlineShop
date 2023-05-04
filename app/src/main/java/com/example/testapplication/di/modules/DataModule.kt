package com.example.testapplication.di.modules

import android.content.Context
import com.example.data.old.datasource.local.LocalDataSource
import com.example.data.old.datasource.local.LocalDataSourceImpl
import com.example.data.old.datasource.remote.RemoteDataSource
import com.example.data.old.datasource.remote.RemoteDataSourceImpl
import com.example.testapplication.di.scopes.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/*
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
        fun provideApiService(): com.example.network.ApiService = com.example.network.ApiFactory.getApiService()

        @ApplicationScope
        @Provides
        fun provideUsersDao(context: Context): com.example.database.UsersDao =
            com.example.database.UsersDatabase.getInstance(context).usersDao()

        @ApplicationScope
        @Provides
        fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
    }


}*/
