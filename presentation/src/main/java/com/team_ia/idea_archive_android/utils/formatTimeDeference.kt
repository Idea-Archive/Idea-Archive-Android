package com.team_ia.idea_archive_android.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun String.formatTimeDifference(): String {
    val regTime = this
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val regDateTime = LocalDateTime.parse(regTime, formatter)

    val diffMinutes = ChronoUnit.MINUTES.between(regDateTime, currentDateTime)
    if (diffMinutes < 1) {
        return "방금 전"
    } else if (diffMinutes < 60) {
        return "${diffMinutes}분 전"
    }

    val diffHours = ChronoUnit.HOURS.between(regDateTime, currentDateTime)
    if (diffHours < 24) {
        return "${diffHours}시간 전"
    }

    val diffDays = ChronoUnit.DAYS.between(regDateTime, currentDateTime)
    if (diffDays < 30) {
        return "${diffDays}일 전"
    }

    val diffMonths = (diffDays / 30).toInt()
    if (diffMonths < 12) {
        return "${diffMonths}달 전"
    }

    val diffYears = (diffDays / 365).toInt()
    return "${diffYears}년 전"
}
