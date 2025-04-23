package com.example.hotelbooking_android.domain.model

import com.example.hotelbooking_android.data.remote.dto.UserFormDto

data class UserForm(
    val name: String,
    val email: String
)

fun UserForm.toDto(): UserFormDto {
    return UserFormDto(
        name = name,
        email = email
    )
}