package com.example.hotelbooking_android.core.di

import com.example.hotelbooking_android.data.remote.api.BookingApiClient
import com.example.hotelbooking_android.data.repository.BookingRepositoryImpl
import com.example.hotelbooking_android.domain.repository.BookingRepository
import com.example.hotelbooking_android.presentation.booking.BookingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val bookingModule = module {

    single {
        BookingApiClient(get())
    }

    single<BookingRepository> {
        BookingRepositoryImpl(get())
    }

    viewModel {
        BookingViewModel(get())
    }
}