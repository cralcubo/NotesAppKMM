package com.croman.notesappkmm.domain.note

import com.croman.notesappkmm.domain.time.DateTimeUtil

class SearchNotes {
    fun execute(notes: List<Note>, query: String): List<Note> {
        if(query.isBlank()) {
            return notes
        }
        return notes.filter { matcher(it.title, query) || matcher(it.content, query) }
            .sortedBy { DateTimeUtil.toEpochMillis(it.created) }
    }

    private fun matcher(orig: String, target: String) =
        orig.trim().lowercase().contains(target.lowercase())
}