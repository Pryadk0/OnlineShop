package com.example.testapplication.glue.authentication.mappers

import com.example.authentication.domain.entities.User
import com.example.authentication.entities.UserDataEntity
import javax.inject.Inject


class AuthenticationRepositoryAdapterMapper @Inject constructor() {

    fun mapUserDataEntityToUser(userDataEntity: UserDataEntity?): User? =
        userDataEntity?.let {
            User(userDataEntity.firstName, userDataEntity.lastName, userDataEntity.email)
        }

    fun mapUserToUserDataEntity(user: User): UserDataEntity =
        UserDataEntity(user.firstName, user.lastName, user.email)

}