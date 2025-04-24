package com.example.hotelbooking_android.presentation.common

sealed class ResourceState<out T> {
    data object Loading : ResourceState<Nothing>()
    data class Success<out T>(val data: T) : ResourceState<T>()
    data class Error(val message: String) : ResourceState<Nothing>()
}