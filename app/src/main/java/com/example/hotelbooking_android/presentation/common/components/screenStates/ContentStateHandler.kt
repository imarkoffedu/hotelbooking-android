package com.example.hotelbooking_android.presentation.common.components.screenStates

import androidx.compose.runtime.Composable

@Composable
fun <T> ContentStateHandler(
    isLoading: Boolean,
    errorMessage: String?,
    items: List<T>,
    loadingContent: @Composable () -> Unit,
    errorContent: @Composable (String) -> Unit,
    emptyContent: @Composable () -> Unit,
    content: @Composable (List<T>) -> Unit
) {
    when {
        isLoading -> loadingContent()
        errorMessage != null -> errorContent(errorMessage)
        items.isEmpty() -> emptyContent()
        else -> content(items)
    }
}