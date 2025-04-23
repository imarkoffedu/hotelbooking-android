package com.example.hotelbooking_android.domain.model

import java.util.UUID

data class User(
    val id: UUID,
    val name: String,
    val email: String
)
