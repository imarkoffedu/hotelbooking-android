package com.example.hotelbooking_android.core.di

import com.example.hotelbooking_android.data.remote.api.UserApiClient
import com.example.hotelbooking_android.data.repository.UserRepositoryImpl
import com.example.hotelbooking_android.domain.repository.UserRepository
import com.example.hotelbooking_android.presentation.user.UserViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val userModule = module {
    single {
        UserApiClient(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }

    viewModel {
        UserViewModel(get())
    }
}