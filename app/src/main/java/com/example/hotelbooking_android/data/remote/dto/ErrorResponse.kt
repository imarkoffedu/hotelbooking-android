package com.example.hotelbooking_android.data.remote.dto

import java.sql.Timestamp

data class ErrorResponse(
    val status: Int,
    val message: String,
    val timestamp: Timestamp
)
