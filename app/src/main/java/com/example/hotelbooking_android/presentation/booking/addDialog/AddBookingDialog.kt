package com.example.hotelbooking_android.presentation.booking.addDialog

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import com.example.hotelbooking_android.presentation.common.components.DialogSubmitter
import com.example.hotelbooking_android.presentation.common.components.MinimalDialog
import com.example.hotelbooking_android.presentation.common.components.datePicker.OutlinedDateField
import com.example.hotelbooking_android.presentation.user.chooser.UserChooserField
import java.util.UUID

@Composable
fun AddBookingDialog(
    booking: Booking? = null,
    onDismiss: () -> Unit,
    onCreate: suspend (BookingForm) -> Unit,
    onUpdate: suspend (UUID, BookingForm) -> Unit
) {
    var formState by remember { mutableStateOf(
        BookingFormState.fromBooking(booking)
    ) }

    suspend fun submit() {
        if (!formState.validate()) return

        val submittedForm = with (formState) {
             BookingForm(
                userId = user!!.id,
                roomNumber = roomNumber!!,
                startDate = startDate!!,
                endDate = endDate!!,
                bookingStatus = bookingStatus
            )
        }

        if (booking != null) onUpdate(booking.id, submittedForm)
        else onCreate(submittedForm)
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
                else stringResource(R.string.create_booking_button)
        )
    ) {
        UserChooserField(
            value = formState.user,
            onValueChange = { formState = formState.updateUser(it) }
        )
        OutlinedTextField(
            value = formState.roomNumber?.toString() ?: "",
            onValueChange = {
                formState = formState.updateRoomNumber(it.toIntOrNull())
            },
            label = { Text(stringResource(R.string.add_booking_room_number)) }
        )
        OutlinedDateField(
            value = formState.startDate,
            onValueChange = { formState = formState.updateStartDate(it) },
            label = { Text(stringResource(R.string.add_booking_start_date)) }
        )
        OutlinedDateField(
            value = formState.endDate,
            onValueChange = { formState = formState.updateEndDate(it) },
            label = { Text(stringResource(R.string.add_booking_end_date)) }
        )
    }
}