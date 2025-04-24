package com.example.hotelbooking_android.presentation.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.domain.model.UserForm
import com.example.hotelbooking_android.domain.repository.UserRepository
import com.example.hotelbooking_android.presentation.common.BaseViewModel
import com.example.hotelbooking_android.presentation.common.ResourceState
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): BaseViewModel() {

    var usersState by mutableStateOf<ResourceState<List<User>>>(ResourceState.Loading)
        private set

    fun loadUsers() {
        loadData(
            fetch = { repository.getAllUsers() },
            onStateChange = { usersState = it }
        )
    }

    private fun updateUsers(
        transform: (List<User>) -> List<User>
    ) {
        updateResource(
            currentState = usersState,
            transform = transform,
            onStateChange = { usersState = it }
        )
    }

    fun addUser(userForm: UserForm) {
        viewModelScope.launch {
            val newUser = repository.createUser(userForm)
            updateUsers { currentUsers -> currentUsers + newUser }
        }
    }

    val users: List<User>
        get() = when (val state = usersState) {
            is ResourceState.Success -> state.data
            else -> emptyList()
        }

    val isLoading: Boolean
        get() = usersState is ResourceState.Loading

    val errorMessage: String?
        get() = when (val state = usersState) {
            is ResourceState.Error -> state.message
            else -> null
        }
}