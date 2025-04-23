package com.example.hotelbooking_android.domain.model

import com.example.hotelbooking_android.data.remote.dto.UserDto
import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val email: String
)

fun User.toDto() = UserDto(
    id = id.toString(),
    name = name,
    email = email
)