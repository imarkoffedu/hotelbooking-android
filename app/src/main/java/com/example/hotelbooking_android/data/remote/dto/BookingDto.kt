package com.example.hotelbooking_android.data.remote.dto

import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import com.example.hotelbooking_android.domain.model.Booking
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.UUID

@Serializable
data class BookingDto(
    val id: String,
    val userId: String,
    val roomNumber: Int,
    val startDate: String, // 2025-04-23
    val endDate: String,
    val status: BookingStatus
)

fun BookingDto.toDomain() = Booking(
    id = UUID.fromString(id),
    userId = UUID.fromString(userId),
    roomNumber = roomNumber,
    startDate = LocalDate.parse(startDate),
    endDate = LocalDate.parse(endDate),
    bookingStatus = status
)