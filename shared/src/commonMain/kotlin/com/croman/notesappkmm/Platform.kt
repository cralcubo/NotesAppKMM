package com.croman.notesappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform