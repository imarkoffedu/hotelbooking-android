package com.example.hotelbooking_android.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.hotelbooking_android.R

class DialogSubmitter(
    val onSubmit: () -> Unit,
    val onSubmitText: String? = null,
    val isLoading: Boolean = false
)

@Composable
fun MinimalDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    dialogSubmitter: DialogSubmitter? = null,
    title: String? = null,
    content: @Composable () -> Unit
) {

    var errorMessage by remember { mutableStateOf("") }

    fun submit() {
        try {
            dialogSubmitter?.onSubmit?.invoke()
        }
        catch (e: Exception) {
            errorMessage = e.message ?: "An error occurred"
        }
    }

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MinimalDialogTitle(title)

                content()

                if (errorMessage.isNotEmpty()) {
                    ErrorMessage(errorMessage)
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CancellationButton(onDismissRequest)
                        SubmitterButton(dialogSubmitter, ::submit)
                    }
                }
            }
        }
    }
}

@Composable
fun MinimalDialogTitle(
    title: String?
) {
    if (title != null) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@Composable
fun CancellationButton(
    onDismissRequest: () -> Unit
) {
    TextButton(
        onClick = onDismissRequest,
        modifier = Modifier
    ) {
        Text(stringResource(R.string.close_dialog_button))
    }
}

@Composable
fun ErrorMessage(
    errorMessage: String
) {
    Text(
        text = errorMessage,
        color = MaterialTheme.colorScheme.error,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun SubmitterButton(
    dialogSubmitter: DialogSubmitter?,
    onSubmit: () -> Unit
) {
    if (dialogSubmitter != null) {
        TextButton(
            onClick = onSubmit,
            enabled = !dialogSubmitter.isLoading,
            modifier = Modifier
        ) {
            Text(
                text = dialogSubmitter.onSubmitText
                    ?: stringResource(R.string.submit_dialog_button)
            )

            if (dialogSubmitter.isLoading) {
                CircularProgressIndicator()
            }
        }
    }
}