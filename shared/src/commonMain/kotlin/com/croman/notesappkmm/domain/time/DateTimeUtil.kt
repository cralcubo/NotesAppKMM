package com.croman.notesappkmm.domain.time

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

object DateTimeUtil {
    private val sysTimeZone = TimeZone.currentSystemDefault()

    val now: LocalDateTime
        get() = Clock.System.now().toLocalDateTime(sysTimeZone)

    fun toEpochMillis(dateTime: LocalDateTime) =
        dateTime.toInstant(sysTimeZone).toEpochMilliseconds()

    fun epochMilliToLocalDateTime(epoch: Long) =
        Instant.fromEpochMilliseconds(epoch).toLocalDateTime(sysTimeZone)
    fun formatNoteDate(dateTime: LocalDateTime): String {
        val month = dateTime.month.name.lowercase().take(3).replaceFirstChar { it.uppercase() }
        val day = if(dateTime.dayOfMonth < 10) "0${dateTime.dayOfMonth}" else dateTime.dayOfMonth
        val year = dateTime.year
        val hour = if(dateTime.hour < 10) "0${dateTime.hour}" else dateTime.hour
        val minute = if(dateTime.minute < 10) "0${dateTime.minute}" else dateTime.minute

        return buildString {
            append(month)
            append(" ")
            append(day)
            append(" ")
            append(year)
            append(", ")
            append(hour)
            append(":")
            append(minute)
        }
    }

}