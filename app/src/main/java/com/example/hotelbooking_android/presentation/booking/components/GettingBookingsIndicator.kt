package com.example.hotelbooking_android.presentation.booking.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.components.LoadingScreenIndicator

@Composable
fun GettingBookingsIndicator() {
    LoadingScreenIndicator(
        label = stringResource(R.string.getting_bookings),
    )
}