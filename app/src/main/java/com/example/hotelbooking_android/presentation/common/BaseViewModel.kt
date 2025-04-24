package com.example.hotelbooking_android.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> loadData(
        fetch: suspend () -> T,
        onStateChange: (ResourceState<T>) -> Unit
    ) {
        viewModelScope.launch {
            onStateChange(ResourceState.Loading)
            try {
                val data = fetch()
                onStateChange(ResourceState.Success(data))
            } catch (e: Exception) {
                onStateChange(ResourceState.Error(e.message ?: "Unknown error"))
            }
        }
    }

    protected fun <T> updateResource(
        currentState: ResourceState<T>,
        transform: (T) -> T,
        onStateChange: (ResourceState<T>) -> Unit
    ) {
        when (val state = currentState) {
            is ResourceState.Success -> {
                val updatedData = transform(state.data)
                onStateChange(ResourceState.Success(updatedData))
            }
            else -> return
        }
    }
}