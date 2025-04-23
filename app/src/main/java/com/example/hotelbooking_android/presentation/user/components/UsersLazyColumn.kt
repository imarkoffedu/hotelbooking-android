package com.example.hotelbooking_android.presentation.user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.domain.model.User
import com.example.hotelbooking_android.presentation.components.UserCard

@Composable
fun UsersLazyColumn(
    users: List<User>,
    innerPadding: PaddingValues = PaddingValues(16.dp),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(
                user = user,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}