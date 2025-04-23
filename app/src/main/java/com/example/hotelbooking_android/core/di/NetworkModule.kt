package com.example.hotelbooking_android.core.di

import com.example.hotelbooking_android.data.remote.NetworkModule
import org.koin.dsl.module

val networkModule = module {
    single {
        NetworkModule().provideHttpClient()
    }
}