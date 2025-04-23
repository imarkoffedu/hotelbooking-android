package com.example.hotelbooking_android.domain.model

import com.example.hotelbooking_android.data.remote.dto.BookingFormDto
import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import java.time.LocalDate
import java.util.UUID

data class BookingForm (
    val userId: UUID,
    val roomNumber: Int,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val bookingStatus: BookingStatus
)

fun BookingForm.toDto() = BookingFormDto(
    userId = userId.toString(),
    roomNumber = roomNumber,
    startDate = startDate.toString(),
    endDate = endDate.toString(),
    status = bookingStatus
)