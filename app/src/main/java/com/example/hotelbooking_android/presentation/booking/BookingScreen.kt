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
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.presentation.booking.components.AddBookingDialog
import com.example.hotelbooking_android.presentation.booking.components.BookingAddFloatingButton
import com.example.hotelbooking_android.presentation.booking.components.BookingsLazyColumn
import com.example.hotelbooking_android.presentation.booking.components.GettingBookingsError
import com.example.hotelbooking_android.presentation.booking.components.GettingBookingsIndicator
import com.example.hotelbooking_android.presentation.booking.components.NoBookingsWarning
import com.example.hotelbooking_android.presentation.common.components.ScreenTopBar
import org.koin.androidx.compose.koinViewModel

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

    Scaffold(
        topBar = { ScreenTopBar(stringResource(R.string.bookings_title)) },
        bottomBar = { BookingAddFloatingButton(onClick = ::openAddBookingModal) }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            when {
                viewModel.isLoading -> GettingBookingsIndicator()
                viewModel.errorMessage != null -> GettingBookingsError(viewModel.errorMessage)
                viewModel.bookings.isEmpty() -> NoBookingsWarning()
                else -> BookingsLazyColumn(viewModel.bookings)
            }
        }
    }

    if (isAddModalOpened) {
        AddBookingDialog(
            booking = selectedBooking,
            onDismiss = ::closeAddBookingModal,
            onSubmit = { /* TODO */ }
        )
    }
}