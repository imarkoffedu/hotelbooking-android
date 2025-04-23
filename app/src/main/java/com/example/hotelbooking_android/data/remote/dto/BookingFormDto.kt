package com.example.hotelbooking_android.data.remote.dto

import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import kotlinx.serialization.Serializable

@Serializable
data class BookingFormDto(
    val userId: String,
    val roomNumber: Int,
    val startDate: String, // 2025-04-23
    val endDate: String,
    val status: BookingStatus
)
