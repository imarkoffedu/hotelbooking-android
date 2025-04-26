package com.example.hotelbooking_android.data.remote.api.routes

import io.ktor.resources.Resource

@Suppress("unused")
@Resource("/bookings")
class BookingsApi {
    @Resource("/")
    class GetBookings(val parent: BookingsApi = BookingsApi())

    @Resource("/")
    class CreateBooking(val parent: BookingsApi = BookingsApi())

    @Resource("{id}")
    class Booking(val parent: BookingsApi = BookingsApi(), val id: String) {
        @Resource("")
        class Get(val parent: Booking)

        @Resource("")
        class Update(val parent: Booking)

        @Resource("")
        class Delete(val parent: Booking)
    }

    @Resource("user/{userId}")
    class UserBookings(val parent: BookingsApi = BookingsApi(), val userId: String) {
        class Get(val parent: UserBookings)
    }
}