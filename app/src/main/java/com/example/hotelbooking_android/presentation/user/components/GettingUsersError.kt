package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.components.EmptyScreenWarning

@Composable
fun GettingUsersError(
    error: String? = null,
) {
    EmptyScreenWarning(
        imageVector = Icons.Default.Close,
        title = stringResource(R.string.getting_users_error),
        contentDescription = error
    )
}