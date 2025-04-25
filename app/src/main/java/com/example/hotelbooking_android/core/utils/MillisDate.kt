package com.example.hotelbooking_android.core.utils

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

typealias MillisDate = Long

fun MillisDate.toLocalDate(
    zone: ZoneId = ZoneId.systemDefault()
): LocalDate =
    Instant.ofEpochMilli(this)
        .atZone(zone)
        .toLocalDate()