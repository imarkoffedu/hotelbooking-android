package com.example.hotelbooking_android.domain.repository

import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import java.util.UUID

interface BookingRepository {
    suspend fun getAllBookings(): List<Booking>
    suspend fun getBookingById(id: UUID): Booking
    suspend fun createBooking(bookingForm: BookingForm): Booking
    suspend fun updateBooking(id: UUID, bookingForm: BookingForm): Booking
    suspend fun deleteBooking(id: UUID)
    suspend fun getBookingsByUserId(userId: UUID): List<Booking>
}