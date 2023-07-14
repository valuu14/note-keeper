package com.example.notekeeper.domain

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notekeeper.MainActivity
import com.example.notekeeper.R
import com.example.notekeeper.constants.NOTE_POSITION

class NoteRecyclerAdapter(private val context: Context, private val notes: List<Note>) : RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]

        holder.notePosition = position
        holder.textCourse?.text = note.course?.title
        holder.textTitle?.text = note.title
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse: TextView? = itemView.findViewById(R.id.textCourse)
        val textTitle: TextView? = itemView.findViewById(R.id.textTitle)
        var notePosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                System.err.println("POSITION $notePosition")

                context.startActivity(intent)
            }
        }
    }
}