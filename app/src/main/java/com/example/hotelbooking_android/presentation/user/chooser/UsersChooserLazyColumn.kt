package com.example.hotelbooking_android.presentation.user.chooser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.hotelbooking_android.domain.model.User
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.presentation.common.components.entityCards.UserCard

@Composable
fun UsersChooserLazyColumn(
    users: List<User>,
    onUserClick: (User) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users) { user ->
            UserCard(
                user = user,
                onClick = onUserClick
            )
        }
    }
}