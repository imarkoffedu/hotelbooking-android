package com.example.hotelbooking_android.data.repository

import com.example.hotelbooking_android.data.remote.api.UserApiClient
import com.example.hotelbooking_android.data.remote.dto.toDomain
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.domain.model.UserForm
import com.example.hotelbooking_android.domain.model.toDto
import com.example.hotelbooking_android.domain.repository.UserRepository

class UserRepositoryImpl(
    private val api: UserApiClient,
): UserRepository {

    override suspend fun getAllUsers(): List<User> {
        val users = api.getAllUsers()
        return users.map { it.toDomain() }
    }

    override suspend fun getUserById(id: String): User {
        val user = api.getUserById(id.toString())
        return user.toDomain()
    }

    override suspend fun createUser(userForm: UserForm): User {
        val newUser = api.createUser(userForm.toDto())
        return newUser.toDomain()
    }
}