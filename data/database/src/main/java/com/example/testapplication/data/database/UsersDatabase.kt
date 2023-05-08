package com.example.testapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDbModel::class], version = 2, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: UsersDatabase? = null
        private val LOCK: Any = Any()
        private const val DB_NAME = "users.db"

        fun getInstance(context: Context): UsersDatabase {
            synchronized(LOCK) {
                INSTANCE?.let { return it }

                val dB = Room.databaseBuilder(context, UsersDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = dB
                return dB
            }
        }
    }

    abstract fun usersDao(): UsersDao
}