package com.example.hotelbooking_android.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyScreenWarning(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    titleModifier: Modifier = Modifier,
    imageVector: ImageVector,
    title: String,
    contentDescription: String? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = imageVector,
            modifier = iconModifier
                .padding(bottom = 8.dp)
                .size(64.dp),
            contentDescription = title,
            tint = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = titleModifier
                .padding(horizontal = 16.dp)
        )
        if (contentDescription != null) {
            Text(
                text = contentDescription,
                textAlign = TextAlign.Center,
                modifier = titleModifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}