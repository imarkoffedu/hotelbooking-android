package com.example.hotelbooking_android.presentation.booking

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.hotelbooking_android.domain.model.Booking
import com.example.hotelbooking_android.domain.model.BookingForm
import com.example.hotelbooking_android.domain.repository.BookingRepository
import com.example.hotelbooking_android.presentation.common.BaseViewModel
import com.example.hotelbooking_android.presentation.common.ResourceState
import kotlinx.coroutines.launch


class BookingViewModel(
    private val repository: BookingRepository
): BaseViewModel() {

    var bookingsState by mutableStateOf<ResourceState<List<Booking>>>(ResourceState.Loading)
        private set

    fun loadBookings() {
        loadData(
            fetch = { repository.getAllBookings() },
            onStateChange = { bookingsState = it }
        )
    }

    private fun updateBookings(
        transform: (List<Booking>) -> List<Booking>
    ) {
        updateResource(
            currentState = bookingsState,
            transform = transform,
            onStateChange = { bookingsState = it }
        )
    }

    fun createBooking(bookingForm: BookingForm) {
        viewModelScope.launch {
            val newBooking = repository.createBooking(bookingForm)
            updateBookings { bookings -> bookings + newBooking }
        }
    }

    val bookings: List<Booking>
        get() = when (val state = bookingsState) {
            is ResourceState.Success -> state.data
            else -> emptyList()
        }

    val isLoading: Boolean
        get() = bookingsState is ResourceState.Loading

    val errorMessage: String?
        get() = when (val state = bookingsState) {
            is ResourceState.Error -> state.message
            else -> null
        }
}