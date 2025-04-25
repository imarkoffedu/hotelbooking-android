package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.components.screenStates.EmptyScreenWarning

@Composable
fun NoBookingsWarning() {
    EmptyScreenWarning(
        imageVector = Icons.Default.Home,
        title = stringResource(R.string.no_bookings_warning)
    )
}