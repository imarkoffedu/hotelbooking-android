package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.UserForm
import com.example.hotelbooking_android.presentation.common.components.DialogSubmitter
import com.example.hotelbooking_android.presentation.common.components.MinimalDialog

@Composable
fun AddUserDialog(
    onDismiss: () -> Unit,
    onSubmit: (UserForm) -> Unit
) {
    var formState by remember {
        mutableStateOf(UserFormState())
    }
    var isSubmitting by remember { mutableStateOf(false) }

    fun validate() = formState.name.isNotBlank() && formState.email.isNotBlank()

    fun submit() {
        if (isSubmitting) return

        if (validate()) {
            isSubmitting = true
            onSubmit(UserForm(formState.name, formState.email))
            onDismiss()
        } else {
            formState = formState.copy(
                showNameError = formState.name.isBlank(),
                showEmailError = formState.email.isBlank()
            )
        }
    }

    MinimalDialog(
        onDismissRequest = onDismiss,
        dialogSubmitter = DialogSubmitter(
            onSubmit = ::submit,
            onSubmitText = stringResource(R.string.add_user_dialog_submit),
            isLoading = isSubmitting
        ),
        title = stringResource(R.string.add_user_dialog_title)
    ) {
        OutlinedTextField(
            value = formState.name,
            onValueChange = {
                formState = formState.copy(
                    name = it,
                    showNameError = false
                )
            },
            label = { Text(stringResource(R.string.add_user_name_label)) },
            placeholder = { Text(stringResource(R.string.add_user_name_placeholder)) },
            isError = formState.showNameError
        )

        OutlinedTextField(
            value = formState.email,
            onValueChange = {
                formState = formState.copy(
                    email = it,
                    showEmailError = false
                )
            },
            label = { Text(stringResource(R.string.add_user_email_label)) },
            placeholder = { Text(stringResource(R.string.add_user_email_placeholder)) },
            isError = formState.showEmailError
        )
    }
}

private data class UserFormState(
    val name: String = "",
    val email: String = "",
    val showNameError: Boolean = false,
    val showEmailError: Boolean = false
)