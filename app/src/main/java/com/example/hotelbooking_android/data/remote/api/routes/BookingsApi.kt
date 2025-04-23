package com.example.hotelbooking_android.data.remote.api.routes

import com.example.hotelbooking_android.data.remote.dto.BookingFormDto
import io.ktor.resources.Resource

@Suppress("unused")
@Resource("/bookings")
class BookingsApi {
    class GetBookings(val parent: BookingsApi = BookingsApi())

    class CreateBooking(val parent: BookingsApi = BookingsApi(), val bookingForm: BookingFormDto)

    @Resource("{id}")
    class Booking(val id: String, val parent: BookingsApi = BookingsApi()) {
        class Get(val parent: Booking)

        class Update(val parent: Booking, val bookingForm: BookingFormDto)

        class Delete(val parent: Booking)
    }

    @Resource("user/{userId}")
    class UserBookings(val parent: BookingsApi = BookingsApi(), val userId: String) {
        class Get(val parent: UserBookings)
    }
}