package com.example.hotelbooking_android.presentation.user.chooser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.presentation.common.components.DialogSubmitter
import com.example.hotelbooking_android.presentation.common.components.MinimalDialog
import com.example.hotelbooking_android.presentation.user.UserViewModel
import com.example.hotelbooking_android.presentation.user.components.UserContentStateHandler
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserChooserDialog(
    userViewModel: UserViewModel? = null,
    onUserChange: (User?) -> Unit,
    onDismiss: () -> Unit,
    isOpened: Boolean
) {
    val viewModel: UserViewModel = userViewModel ?: koinViewModel()

    // handle isOpened here for lazy loading
    LaunchedEffect(isOpened) {
        if (isOpened) {
            viewModel.loadUsers()
        }
    }

    if (isOpened) {
        MinimalDialog(
            title = stringResource(R.string.choose_user_dialog_title),
            onDismissRequest = onDismiss,
            dialogSubmitter = DialogSubmitter(
                onSubmit = { onUserChange(null) },
                onSubmitText = stringResource(R.string.clear_user_field_button)
            )
        ) {
            UserContentStateHandler(
                viewModel = viewModel,
                usersContent = {
                    UsersChooserLazyColumn(
                        users = it,
                        onUserClick = onUserChange
                    )
                }
            )
        }
    }
}