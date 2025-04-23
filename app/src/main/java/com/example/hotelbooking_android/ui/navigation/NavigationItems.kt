package com.example.hotelbooking_android.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.hotelbooking_android.R

data class NavigationItem(
    val title: Int,
    val icon: ImageVector,
    val route: String
)

val navigationItems = listOf(
    NavigationItem(
        title = R.string.bookings_title,
        icon = Icons.Default.Home,
        route = Screen.Bookings.route
    ),
    NavigationItem(
        title = R.string.users_title,
        icon = Icons.Default.AccountCircle,
        route = Screen.Users.route
    )
)