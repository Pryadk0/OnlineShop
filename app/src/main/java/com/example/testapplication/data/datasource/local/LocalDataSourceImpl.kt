package com.example.testapplication.data.datasource.local

import com.example.testapplication.data.database.UsersDao
import com.example.testapplication.data.datasource.local.model.UserDbModel
import com.example.testapplication.data.mapper.Mapper
import com.example.testapplication.domain.User
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val usersDao: UsersDao,
    private val mapper: Mapper
) :
    LocalDataSource {

    override fun getUserFromDb(firstName: String): User? {
        val callable: Callable<UserDbModel?> = Callable {
            return@Callable usersDao.getUser(firstName)
        }
        val futureTask: FutureTask<UserDbModel?> = FutureTask(callable)
        Thread(futureTask).start()
        val user = futureTask.get()
        return user?.let { mapper.mapUserDbModelToUser(it) }
    }

    override fun writeUserInDb(user: User) {
        Thread { usersDao.insertUser(mapper.mapUserToUserDbModel(user)) }.start()
    }

}