package com.example.testapplication.glue.authentication.repositories

import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import com.example.testapplication.data.authentication.AuthenticationDataRepository
import com.example.testapplication.glue.authentication.mappers.AuthenticationRepositoryAdapterMapper
import javax.inject.Inject

class AuthenticationRepositoryAdapter @Inject constructor(
    private val dataRepository: AuthenticationDataRepository,
    private val mapper: AuthenticationRepositoryAdapterMapper
): AuthenticationRepository {

    override fun getUserFormDb(firstName: String): User? =
        mapper.mapUserDataEntityToUser(dataRepository.getUserFormDb(firstName))

    override fun writeUserInDb(user: User) {
        dataRepository.writeUserInDb(mapper.mapUserToUserDataEntity(user))
    }
}