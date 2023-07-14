package com.example.notekeeper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.domain.NoteRecyclerAdapter
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

        val listItems = findViewById<RecyclerView>(R.id.listItems)
        listItems.layoutManager = LinearLayoutManager(this);

        listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes)
    }

    override fun onResume() {
        super.onResume()
        val listItems = findViewById<RecyclerView>(R.id.listItems)
        listItems.adapter?.notifyDataSetChanged()
    }
}