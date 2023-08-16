package com.croman.notesappkmm.domain.note

import com.croman.notesappkmm.presentation.Color
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        val randomColor: Color
            get() = Color.values().random()
    }
}
