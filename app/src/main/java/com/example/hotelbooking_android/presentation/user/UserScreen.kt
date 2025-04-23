package com.example.hotelbooking_android.presentation.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.hotelbooking_android.presentation.user.components.AddUserDialog
import com.example.hotelbooking_android.presentation.user.components.GettingUsersError
import com.example.hotelbooking_android.presentation.user.components.GettingUsersIndicator
import com.example.hotelbooking_android.presentation.user.components.NoUsersWarning
import com.example.hotelbooking_android.presentation.user.components.UserAddFloatingButton
import com.example.hotelbooking_android.presentation.user.components.UserTopBar
import com.example.hotelbooking_android.presentation.user.components.UsersLazyColumn

@Composable
fun UserScreen() {
    val viewModel: UserViewModel = koinViewModel()

    var showAddUserDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    Scaffold(
        topBar = {
            UserTopBar()
        },
        bottomBar = {
            UserAddFloatingButton(
                onClick = { showAddUserDialog = true }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (viewModel.isLoading) { GettingUsersIndicator() }
            else if (viewModel.errorMessage != null) { GettingUsersError(viewModel.errorMessage) }
            else if (viewModel.users.isEmpty()) { NoUsersWarning() }
            else { UsersLazyColumn(viewModel.users) }
        }
    }

    if (showAddUserDialog) {
        AddUserDialog(
            onDismiss = { showAddUserDialog = false },
            onSubmit = { userForm ->
                viewModel.addUser(userForm)
                showAddUserDialog = false
            }
        )
    }
}