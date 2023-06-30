package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.notekeeper.constants.EXTRA_NOTE_POSITION
import com.example.notekeeper.domain.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        val button = findViewById<FloatingActionButton>(R.id.fabNotesList)
        button.setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        val notesList = findViewById<ListView>(R.id.notesListView)
        notesList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataManager.notes)

        notesList.setOnItemClickListener {parent, view, position, id ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        val notesList = findViewById<ListView>(R.id.notesListView)
        (notesList.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }
}