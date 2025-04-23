package com.example.hotelbooking_android.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelbooking_android.ui.navigation.AppNavHost
import com.example.hotelbooking_android.ui.navigation.MainNavigationBar

@Composable
fun MainScreen() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { MainNavigationBar(navController) }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}