package com.example.hotelbooking_android.data.remote.dto

import com.example.hotelbooking_android.domain.model.User
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserDto(
    val id: String,
    val name: String,
    val email: String
)

fun UserDto.toDomain() = User(
    id = UUID.fromString(id),
    name = name,
    email = email
)