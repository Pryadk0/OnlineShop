package com.example.authentication.datasources.local

import com.example.authentication.datasources.AuthenticationLocalDataSource
import com.example.authentication.entities.UserDataEntity
import com.example.database.UserDbModel
import com.example.database.UsersDao
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import javax.inject.Inject

class AuthenticationLocalDataSourceImpl @Inject constructor(
    private val usersDao: UsersDao,
    private val mapper: AuthenticationLocalDataSourceMapper
) : AuthenticationLocalDataSource {

    override fun getUserFromDb(firstName: String): UserDataEntity? {
        val callable: Callable<UserDbModel?> = Callable {
            return@Callable usersDao.getUser(firstName)
        }
        val futureTask: FutureTask<UserDbModel?> = FutureTask(callable)
        Thread(futureTask).start()
        val user = futureTask.get()
        return user?.let { mapper.mapUserDbModelToUserDataEntity(it) }
    }

    override fun writeUserInDb(userDataEntity: UserDataEntity) {
        Thread { usersDao.insertUser(mapper.mapUserDataEntityToUserDbModel(userDataEntity)) }.start()
    }

}