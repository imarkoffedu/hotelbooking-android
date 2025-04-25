package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.components.screenStates.LoadingScreenIndicator

@Composable
fun GettingUsersIndicator() {
    LoadingScreenIndicator(
        label = stringResource(R.string.getting_users)
    )
}