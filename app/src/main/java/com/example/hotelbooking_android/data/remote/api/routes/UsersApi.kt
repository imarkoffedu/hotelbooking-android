package com.example.hotelbooking_android.data.remote.api.routes

import io.ktor.resources.Resource

@Suppress("unused")
@Resource("/users")
class UsersApi {
    @Resource("/")
    class GetUsers(val parent: UsersApi = UsersApi())

    @Resource("/")
    class CreateUser(val parent: UsersApi = UsersApi())

    @Resource("{id}")
    class User(val parent: UsersApi = UsersApi(), val id: String) {
        @Resource("/")
        class Get(val parent: User)
    }
}