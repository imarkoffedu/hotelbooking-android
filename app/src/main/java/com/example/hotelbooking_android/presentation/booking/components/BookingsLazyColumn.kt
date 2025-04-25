package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.hotelbooking_android.domain.model.Booking
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.presentation.common.components.entityCards.BookingCard

@Composable
fun BookingsLazyColumn(
    bookings: List<Booking>,
    contentPadding: PaddingValues = PaddingValues(16.dp),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(bookings) { booking ->
            BookingCard(
                booking = booking
            )
        }
    }
}