package com.example.notekeeper.domain

data class Course (val id: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

data class Note (var course: Course? = null, var title: String? = null, var text: String? = null) {
    override fun toString(): String {
        return "$title\n$text"
    }
}