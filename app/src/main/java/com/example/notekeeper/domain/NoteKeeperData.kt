package com.example.notekeeper.domain

data class Course (val id: String, val title: String)

data class Note (var course: Course, var title: String, var text: String)