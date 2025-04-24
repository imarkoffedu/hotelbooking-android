package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.data.remote.dto.type.BookingStatus
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.presentation.common.components.DialogSubmitter
import com.example.hotelbooking_android.presentation.common.components.MinimalDialog
import java.time.LocalDate

@Composable
fun AddBookingDialog(
    booking: Booking? = null,
    onDismiss: () -> Unit,
    onSubmit: (BookingForm) -> Unit
) {
    var formState by remember { mutableStateOf(
        BookingFormState.fromBooking(booking)
    ) }

    var isSubmitting by remember { mutableStateOf(false) }

    fun submit() {
        if (formState.validate()) {
            isSubmitting = true
            with (formState) {
                onSubmit(BookingForm(
                    userId = user!!.id,
                    roomNumber = roomNumber!!,
                    startDate = startDate!!,
                    endDate = endDate!!,
                    bookingStatus = bookingStatus
                ))
            }
        }
    }

    MinimalDialog(
        title =
            if (booking != null) stringResource(R.string.edit_boking_dialog_title)
            else stringResource(R.string.create_booking_dialog_title),
        onDismissRequest = onDismiss,
        dialogSubmitter = DialogSubmitter(
            onSubmit = ::submit,
            onSubmitText =
                if (booking != null) stringResource(R.string.edit_booking_button)
                else stringResource(R.string.create_booking_button),
            isLoading = isSubmitting
        )
    ) {
    }
}

private data class BookingFormState(
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
                user = null,
                roomNumber = it.roomNumber,
                startDate = it.startDate,
                endDate = it.endDate,
                bookingStatus = it.bookingStatus
            )
        } ?: BookingFormState()
    }
}