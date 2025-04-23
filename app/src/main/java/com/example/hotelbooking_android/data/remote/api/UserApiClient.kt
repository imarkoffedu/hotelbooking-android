package com.example.hotelbooking_android.data.remote.api

import com.example.hotelbooking_android.data.remote.api.routes.UsersApi
import com.example.hotelbooking_android.data.remote.dto.UserDto
import com.example.hotelbooking_android.data.remote.dto.UserFormDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class UserApiClient(private val client: HttpClient) {

    suspend fun getAllUsers(): List<UserDto> {
        val response = client.get(
            UsersApi.GetUsers()
        )
        return response.body()
    }

    suspend fun getUserById(id: String): UserDto {
        val response = client.get(
            UsersApi.User.Get(
                UsersApi.User(id = id)
            )
        )
        return response.body()
    }

    suspend fun createUser(userForm: UserFormDto): UserDto {
        val response = client.post(
            UsersApi.CreateUser()
        ) {
            contentType(ContentType.Application.Json)
            setBody(userForm)
        }
        return response.body()
    }
}