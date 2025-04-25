package com.example.hotelbooking_android.presentation.booking.addDialog

import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.User
import java.time.LocalDate

data class BookingFormState(
    val user: User? = null,
    val roomNumber: Int? = null,
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val bookingStatus: BookingStatus = BookingStatus.CONFIRMED
) {
    fun validate() = listOf(user, roomNumber, startDate, endDate).all { it != null }

    companion object {
        fun fromBooking(booking: Booking?) = booking?.let {
            BookingFormState(
                // по хорошому треба вкладати юзера зразу на беці
                user = User(
                    id = booking.userId,
                    name = booking.userId.toString(),
                    email = booking.userId.toString()
                ),
                roomNumber = it.roomNumber,
                startDate = it.startDate,
                endDate = it.endDate,
                bookingStatus = it.bookingStatus
            )
        } ?: BookingFormState()
    }
}

fun BookingFormState.updateRoomNumber(number: Int?) = copy(roomNumber = number)
fun BookingFormState.updateStartDate(date: LocalDate?) = copy(startDate = date)
fun BookingFormState.updateEndDate(date: LocalDate?) = copy(endDate = date)
fun BookingFormState.updateUser(newUser: User?) = copy(user = newUser)