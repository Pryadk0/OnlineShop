package com.example.database.di

import android.content.Context
import com.example.database.UsersDao
import com.example.database.UsersDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DatabaseModule {

    companion object {

        @Singleton
        @Provides
        fun provideUsersDao(context: Context): UsersDao =
            UsersDatabase.getInstance(context).usersDao()
    }
}