package com.example.hotelbooking_android.domain.repository

import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.domain.model.UserForm

interface UserRepository {
    suspend fun getAllUsers(): List<User>
    suspend fun getUserById(id: String): User
    suspend fun createUser(userForm: UserForm): User
}