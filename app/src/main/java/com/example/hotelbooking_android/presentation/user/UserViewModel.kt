package com.example.hotelbooking_android.presentation.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.domain.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {

    var users by mutableStateOf<List<User>>(emptyList())
        private set

    fun loadUsers() {
        viewModelScope.launch {
            users = repository.getAllUsers()
        }
    }
}