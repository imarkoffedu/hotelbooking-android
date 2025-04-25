package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.presentation.common.components.screenStates.ContentStateHandler
import com.example.hotelbooking_android.presentation.user.UserViewModel

@Composable
fun UserContentStateHandler(
    viewModel: UserViewModel,
    contentPadding: PaddingValues = PaddingValues(),
    usersContent: (@Composable (List<User>) -> Unit)? = null
) {
    ContentStateHandler(
        isLoading = viewModel.isLoading,
        errorMessage = viewModel.errorMessage,
        items = viewModel.users,
        loadingContent = { GettingUsersIndicator() },
        errorContent = { GettingUsersError(it) },
        emptyContent = { NoUsersWarning() },
        content = {
            if (usersContent != null) usersContent(it)
            else UsersLazyColumn(it, contentPadding)
        }
    )
}