package com.example.hotelbooking_android.ui.navigation

sealed class Screen(val route: String) {
    object Bookings: Screen("bookings_screen")
    object Users: Screen("users_screen")
}