package com.example.hotelbooking_android.data.remote.api.routes

import com.example.hotelbooking_android.data.remote.dto.UserFormDto
import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
@Resource("/users")
class UsersApi {
    @Resource("/")
    class GetUsers(val parent: UsersApi = UsersApi())

    class CreateUser(val parent: UsersApi = UsersApi(), val userForm: UserFormDto)

    @Resource("{id}")
    class User(val parent: UsersApi = UsersApi(), val id: String) {
        class Get(val parent: User)
    }
}