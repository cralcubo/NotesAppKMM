package com.croman.notesappkmm.domain.data.note

import com.croman.NoteDatabase
import com.croman.NoteEntity
import com.croman.notesappkmm.domain.note.Note
import com.croman.notesappkmm.domain.note.NoteDataSource
import com.croman.notesappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {
    private val queries = db.noteQueries
    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            note.id,
            note.title,
            note.content,
            note.colorHex,
            DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long) =
        queries.getNoteById(id).executeAsOneOrNull()?.toNote()

    override suspend fun getAllNotes()=
        queries.getAllNotes().executeAsList()
            .map { it.toNote() }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}

fun NoteEntity.toNote(): Note =
    Note(
        this.id,
        this.title,
        this.content,
        this.colorHex,
        DateTimeUtil.epochMilliToLocalDateTime(this.created)
    )
