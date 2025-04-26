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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.hotelbooking_android.R
import com.example.hotelbooking_android.presentation.common.hooks.useStateHandler

data class DialogSubmitter(
    val onSubmit: suspend () -> Unit,
    val onSubmitText: String? = null
)

@Composable
fun MinimalDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    dialogSubmitter: DialogSubmitter? = null,
    title: String? = null,
    content: @Composable () -> Unit
) {
    // React Hook "useEffect" is called conditionally. React Hooks must be called in the exact same order in every component render.
    val (isLoading, errorMessage, submit) = useStateHandler(onSubmit = dialogSubmitter?.onSubmit)

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MinimalDialogTitle(title)

                content()

                if (errorMessage.isNotEmpty()) {
                    ErrorMessage(errorMessage = errorMessage)
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CancellationButton(onDismissRequest)
                        SubmitterButton(
                            onSubmit = submit,
                            onSubmitText = dialogSubmitter?.onSubmitText,
                            isLoading = isLoading
                        )
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
                .padding(top = 8.dp)
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
    onSubmit: () -> Unit,
    onSubmitText: String? = null,
    isLoading: Boolean
) {
    TextButton(
        onClick = onSubmit,
        enabled = !isLoading,
        modifier = Modifier
    ) {
        Text(
            text = onSubmitText
                ?: stringResource(R.string.submit_dialog_button)
        )

        if (isLoading) CircularProgressIndicator()
    }
}