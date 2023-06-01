package com.example.testapplication.glue.authentication.mappers

import com.example.testapplication.data.authentication.entities.UserDataEntity
import com.example.testapplication.features.authentication.domain.entities.User
import javax.inject.Inject


internal class AuthenticationRepositoryAdapterMapper @Inject constructor() {

    fun mapUserDataEntityToUser(userDataEntity: UserDataEntity?): User? =
        userDataEntity?.let {
            User(userDataEntity.firstName, userDataEntity.lastName, userDataEntity.email)
        }

    fun mapUserToUserDataEntity(user: User): UserDataEntity =
        UserDataEntity(user.firstName, user.lastName, user.email)

}