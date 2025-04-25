package com.example.hotelbooking_android.presentation.user.chooser

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.domain.model.User

@Composable
fun UserChooserField(
    value: User?,
    onValueChange: (User?) -> Unit
) {
    var isChooserOpened by remember { mutableStateOf(false) }

    fun changeUser(user: User?) {
        onValueChange(user)
        isChooserOpened = false
    }

    OutlinedTextField(
        value = value?.name ?: "",
        onValueChange = { },
        label = { Text(stringResource(R.string.user_label)) },
        placeholder = { Text(stringResource(R.string.no_user_selected_placeholder))},
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = { isChooserOpened = true }) {
                Icon(
                    imageVector = Icons.Outlined.Face,
                    contentDescription = stringResource(R.string.choose_user_button)
                )
            }
        }
    )

    UserChooserDialog(
        isOpened = isChooserOpened,
        onDismiss = { isChooserOpened = false },
        onUserChange = ::changeUser
    )
}