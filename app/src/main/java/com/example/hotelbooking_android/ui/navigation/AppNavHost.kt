package com.example.hotelbooking_android.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hotelbooking_android.presentation.booking.BookingScreen
import com.example.hotelbooking_android.presentation.user.UserScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues(0.dp),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Users.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(Screen.Users.route) {
            UserScreen()
        }
        composable(Screen.Bookings.route) {
             BookingScreen()
        }
    }
}