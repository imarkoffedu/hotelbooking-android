package com.example.hotelbooking_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.hotelbooking_android.core.di.networkModule
import com.example.hotelbooking_android.core.di.userModule
import com.example.hotelbooking_android.presentation.main.MainScreen
import com.example.hotelbooking_android.ui.theme.HotelbookingandroidTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule, userModule)
        }
        setContent {
            HotelbookingandroidTheme {
                MainScreen()
            }
        }
    }
}