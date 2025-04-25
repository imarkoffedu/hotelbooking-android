package com.example.hotelbooking_android.presentation.common.components.entityCards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hotelbooking_android.domain.model.User

@Composable
fun UserCard(
    modifier: Modifier = Modifier,
    user: User,
    onClick: ((User) -> Unit)? = null,
    isSelected: Boolean = false,
) {
    fun click() {
        if (onClick != null) {
            onClick(user)
        }
    }

    Card(
        onClick = ::click,
        border = BorderStroke(
            width = if (isSelected) 2.dp else 0.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = user.name, fontSize = MaterialTheme.typography.titleLarge.fontSize)
            Text(text = user.email)
        }
    }
}