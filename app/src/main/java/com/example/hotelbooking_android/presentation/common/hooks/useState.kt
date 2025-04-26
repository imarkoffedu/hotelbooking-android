package com.example.hotelbooking_android.presentation.common.hooks

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class State<T>(
    val state: T,
    val setState: (T) -> Unit
)

// AND HE EVEN WROTE A FREAKING USE STATE
@Composable
fun <T> useState (initial: T): State<T> {
    var state by remember { mutableStateOf(initial) }

    val setState: (T) -> Unit = { state = it }

    return State(
        state = state,
        setState = setState
    )
}