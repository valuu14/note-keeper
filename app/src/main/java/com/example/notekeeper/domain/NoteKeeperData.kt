package com.example.notekeeper.domain

data class Course (val id: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

data class Note (var course: Course, var title: String, var text: String) {
    override fun toString(): String {
        return "$title\n$text"
    }
}