package com.croman.notesappkmm.domain.data.local

import app.cash.sqldelight.db.SqlDriver
import com.croman.NoteDatabase

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

//fun createDatabase(driverFactory: DriverFactory): NoteDatabase {
//    val driver = driverFactory.createDriver()
//    val database = Database(driver)
//
//    // Do more work with the database (see below).
//}

