package com.example.hotelbooking_android.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserFormDto(
    val name: String,
    val email: String
)
