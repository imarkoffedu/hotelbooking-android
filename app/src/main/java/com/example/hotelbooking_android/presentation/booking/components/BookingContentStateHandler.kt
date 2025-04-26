package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.presentation.booking.BookingViewModel
import com.example.hotelbooking_android.presentation.common.components.screenStates.ContentStateHandler

@Composable
fun BookingContentStateHandler(
    viewModel: BookingViewModel,
    onBookingClick: (Booking) -> Unit,
    contentPadding: PaddingValues = PaddingValues()
) {
    ContentStateHandler(
        isLoading = viewModel.isLoading,
        errorMessage = viewModel.errorMessage,
        items = viewModel.bookings,
        loadingContent = { GettingBookingsIndicator() },
        errorContent = { GettingBookingsError(it) },
        emptyContent = { NoBookingsWarning() },
        content = {
            BookingsLazyColumn(
                bookings = it,
                onBookingClick = onBookingClick,
                contentPadding = contentPadding
            )
        }
    )
}