package com.example.hotelbooking_android.presentation.common.components.entityCards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.Booking

@Composable
fun BookingCard(
    modifier: Modifier = Modifier,
    booking: Booking,
    onClick: (() -> Unit)? = null
) {
    Card(
        onClick = onClick ?: {},
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "#${booking.id}",
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium
            )
            BookingCardPropertyLine(
                name = stringResource(R.string.booking_booker),
                value = "#${booking.userId}"
            )
            BookingCardPropertyLine(
                name = stringResource(R.string.booking_room_number),
                value = booking.roomNumber.toString()
            )
            BookingCardPropertyLine(
                name = stringResource(R.string.booking_start_date),
                value = booking.startDate.toString()
            )
            BookingCardPropertyLine(
                name = stringResource(R.string.booking_end_date),
                value = booking.endDate.toString()
            )
        }
    }
}

@Composable
fun BookingCardPropertyLine(
    name: String,
    value: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(name, fontWeight = FontWeight.Medium)
        Text(value)
    }
}