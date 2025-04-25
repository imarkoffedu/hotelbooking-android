package com.example.hotelbooking_android.presentation.common.components.datePicker

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.hotelbooking_android.R
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedDateField(
    value: LocalDate? = null,
    onValueChange: (LocalDate) -> Unit,
    label: @Composable (() -> Unit)? = null
) {
    var showDatePickerDialog by remember { mutableStateOf(false) }

    val displayedValue = value?.toString() ?: ""

    OutlinedTextField(
        value = displayedValue,
        onValueChange = { },
        readOnly = true,
        label = label,
        placeholder = { Text("YYYY-MM-DD") },
        trailingIcon = {
            IconButton(onClick = { showDatePickerDialog = true }) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = stringResource(R.string.select_date)
                )
            }
        },
    )

    if (showDatePickerDialog) {
        DatePickerModal(
            onDateSelected = { date ->
                date?.let { onValueChange(date) }
            },
            onDismiss = { showDatePickerDialog = false }
        )
    }
}