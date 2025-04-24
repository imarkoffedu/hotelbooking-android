package com.example.hotelbooking_android.data.remote.api

import com.example.hotelbooking_android.data.remote.dto.BookingDto
import com.example.hotelbooking_android.data.remote.api.routes.BookingsApi
import com.example.hotelbooking_android.data.remote.dto.BookingFormDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.*
import io.ktor.client.request.setBody

class BookingApiClient(private val client: HttpClient) {

    suspend fun getAllBookings(): List<BookingDto> {
        val response = client.get(
            BookingsApi.GetBookings()
        )
        return response.body()
    }

    suspend fun getBookingById(id: String): BookingDto {
        val response = client.get(
            BookingsApi.Booking.Get(
                BookingsApi.Booking(id = id)
            )
        )
        return response.body()
    }

    suspend fun createBooking(bookingForm: BookingFormDto): BookingDto {
        val response = client.post(BookingsApi.CreateBooking()) {
            setBody(bookingForm)
        }
        return response.body()
    }

    suspend fun updateBooking(id: String, bookingForm: BookingFormDto): BookingDto {
        val response = client.put(
            BookingsApi.Booking.Update(
                BookingsApi.Booking(id = id)
            )
        ) {
            setBody(bookingForm)
        }
        return response.body()
    }

    suspend fun deleteBooking(id: String) {
        client.delete(
            BookingsApi.Booking.Delete(
                BookingsApi.Booking(id = id)
            )
        )
    }

    suspend fun getUserBookings(userId: String): List<BookingDto> {
        val response = client.get(
            BookingsApi.UserBookings.Get(
                BookingsApi.UserBookings(userId = userId)
            )
        )
        return response.body()
    }
}