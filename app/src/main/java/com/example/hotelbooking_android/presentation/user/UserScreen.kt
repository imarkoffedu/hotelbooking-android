package com.example.hotelbooking_android.presentation.user

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items

@Composable
fun UserScreen() {
    val viewModel: UserViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    LazyColumn {
        items(viewModel.users) { user ->
            Text(user.name)
        }
    }
}