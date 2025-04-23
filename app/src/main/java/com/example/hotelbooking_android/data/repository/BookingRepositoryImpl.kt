package com.example.hotelbooking_android.data.repository

import com.example.hotelbooking_android.data.remote.api.BookingApiClient
import com.example.hotelbooking_android.data.remote.dto.toDomain
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import com.example.hotelbooking_android.domain.model.toDto
import com.example.hotelbooking_android.domain.repository.BookingRepository
import java.util.UUID

class BookingRepositoryImpl(
    private val api: BookingApiClient
): BookingRepository {

    override suspend fun getAllBookings(): List<Booking> {
        val bookings = api.getAllBookings()
        return bookings.map { it.toDomain() }
    }

    override suspend fun getBookingById(id: UUID): Booking {
        val booking = api.getBookingById(id.toString())
        return booking.toDomain()
    }

    override suspend fun createBooking(bookingForm: BookingForm): Booking {
        val newBooking = api.createBooking(bookingForm.toDto())
        return newBooking.toDomain()
    }

    override suspend fun updateBooking(id: UUID, bookingForm: BookingForm): Booking {
        val updatedBooking = api.updateBooking(id.toString(), bookingForm.toDto())
        return updatedBooking.toDomain()
    }

    override suspend fun deleteBooking(id: UUID) {
        api.deleteBooking(id.toString())
    }

    override suspend fun getBookingsByUserId(userId: UUID): List<Booking> {
        val bookings = api.getUserBookings(userId.toString())
        return bookings.map { it.toDomain() }
    }
}