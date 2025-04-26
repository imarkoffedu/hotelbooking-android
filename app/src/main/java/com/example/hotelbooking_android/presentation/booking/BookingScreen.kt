package com.example.hotelbooking_android.presentation.booking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import com.example.hotelbooking_android.presentation.booking.addDialog.AddBookingDialog
import com.example.hotelbooking_android.presentation.booking.components.BookingAddFloatingButton
import com.example.hotelbooking_android.presentation.booking.components.BookingContentStateHandler
import com.example.hotelbooking_android.presentation.common.components.ScreenTopBar
import org.koin.androidx.compose.koinViewModel
import java.util.UUID

@Composable
fun BookingScreen() {

    val viewModel: BookingViewModel = koinViewModel()

    LaunchedEffect(Unit) { viewModel.loadBookings() }

    var isAddModalOpened by remember { mutableStateOf(false) }
    var selectedBooking by remember { mutableStateOf<Booking?>(null) }

    fun openAddBookingModal(booking: Booking? = null) {
        selectedBooking = booking
        isAddModalOpened = true
    }

    fun closeAddBookingModal() {
        selectedBooking = null
        isAddModalOpened = false
    }

    suspend fun createBooking(bookingForm: BookingForm) {
        viewModel.createBooking(bookingForm)
        closeAddBookingModal()
    }

    suspend fun updateBooking(id: UUID, bookingForm: BookingForm) {
        viewModel.updateBooking(id, bookingForm)
        closeAddBookingModal()
    }

    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.bookings_title)) },
        bottomBar = { BookingAddFloatingButton(onClick = ::openAddBookingModal) }
    ) { paddingValues ->

        Column(Modifier.padding(horizontal = 8.dp)) {
            BookingContentStateHandler(
                viewModel = viewModel,
                onBookingClick = ::openAddBookingModal,
                contentPadding = paddingValues
            )
        }
    }

    if (isAddModalOpened) {
        AddBookingDialog(
            booking = selectedBooking,
            onDismiss = ::closeAddBookingModal,
            onCreate = ::createBooking,
            onUpdate = ::updateBooking
        )
    }
}