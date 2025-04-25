package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.components.screenStates.EmptyScreenWarning

@Composable
fun GettingBookingsError(error: String?) {
    EmptyScreenWarning(
        imageVector = Icons.Default.Close,
        title = stringResource(R.string.getting_bookings_error),
        contentDescription = error
    )
}