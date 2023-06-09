package com.example.notekeeper

import com.example.notekeeper.domain.Course
import com.example.notekeeper.domain.Note

object DataManager {
    val courses = HashMap<String, Course>()
    val notes = ArrayList<Note>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = Course("1", "Title 1")
        courses[course.id] = course

        course = Course("2", "Title 2")
        courses[course.id] = course

        course = Course(title = "Title 3", id = "3")
        courses[course.id] = course
    }

    private fun initializeNotes() {
        var note = Note(courses.getValue("1"), "WOW Title", "Text text text")
        notes.add(note)

        note = Note(courses.getValue("2"), "WOW Title2", "Text text text")
        notes.add(note)

        note = Note(courses.getValue("3"), "WOW Title3", "Text text text")
        notes.add(note)
    }
}