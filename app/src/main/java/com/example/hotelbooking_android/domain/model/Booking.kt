package com.example.hotelbooking_android.domain.model

import com.example.hotelbooking_android.data.remote.dto.BookingDto
import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import java.time.LocalDate
import java.util.UUID

data class Booking(
    val id: UUID,
    val userId: UUID,
    val roomNumber: Int,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val bookingStatus: BookingStatus
)

fun Booking.toDto() = BookingDto(
    id = id.toString(),
    userId = userId.toString(),
    roomNumber = roomNumber,
    startDate = startDate.toString(),
    endDate = endDate.toString(),
    bookingStatus = bookingStatus
)