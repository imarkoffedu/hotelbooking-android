package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.components.screenStates.EmptyScreenWarning

@Composable
fun NoUsersWarning() {
    EmptyScreenWarning(
        imageVector = Icons.Default.AccountCircle,
        title = stringResource(R.string.no_users_warning)
    )
}