package com.example.authentication

import com.example.authentication.datasources.AuthenticationLocalDataSource
import com.example.authentication.entities.UserDataEntity
import javax.inject.Inject

class AuthenticationDataRepositoryImpl @Inject constructor(
    private val localDataSource: AuthenticationLocalDataSource
) : AuthenticationDataRepository {

    override fun getUserFormDb(firstName: String): UserDataEntity? =
        localDataSource.getUserFromDb(firstName)

    override fun writeUserInDb(userDataEntity: UserDataEntity) =
        localDataSource.writeUserInDb(userDataEntity)

}