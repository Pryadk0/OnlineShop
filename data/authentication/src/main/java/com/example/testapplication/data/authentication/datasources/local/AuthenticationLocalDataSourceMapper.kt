package com.example.testapplication.data.authentication.datasources.local

import com.example.testapplication.data.authentication.entities.UserDataEntity
import com.example.testapplication.data.database.UserDbModel
import javax.inject.Inject

class AuthenticationLocalDataSourceMapper @Inject constructor() {

    fun mapUserDbModelToUserDataEntity(userDbModel: UserDbModel) = UserDataEntity(
        userDbModel.firstName, userDbModel.lastName, userDbModel.email
    )

    fun mapUserDataEntityToUserDbModel(userDataEntity: UserDataEntity) =
        UserDbModel(userDataEntity.firstName, userDataEntity.lastName, userDataEntity.email)

}