package com.example.uhunt.jetpackClassess.global
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import java.time.Instant
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun getTimeAgo(timestamp: Long): String {
    val instant = Instant.ofEpochSecond(timestamp)
    val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    val now = LocalDateTime.now()

    val period = Period.between(dateTime.toLocalDate(), now.toLocalDate())
    val years = period.years
    val months = period.months

    return when {
        years > 0 && months > 0 -> "$years years and $months months ago"
        years > 0 -> "$years years ago"
        months > 0 -> "$months months ago"
        else -> "Less than a month ago"
    }
}
