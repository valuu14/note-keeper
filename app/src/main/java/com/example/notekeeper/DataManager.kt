package com.example.notekeeper

import com.example.notekeeper.domain.Course
import com.example.notekeeper.domain.Note

class DataManager {
    val courses = HashMap<String, Course>()
    val notes = ArrayList<Note>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {
        var course = Course("1", "Title 1")
        courses[course.id] = course

        course = Course("2", "Title 2")
        courses[course.id] = course

        course = Course(title = "Title 3", id = "3")
        courses[course.id] = course
    }
}