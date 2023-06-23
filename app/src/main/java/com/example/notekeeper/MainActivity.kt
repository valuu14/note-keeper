package com.example.notekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.notekeeper.constants.EXTRA_NOTE_POSITION
import com.example.notekeeper.constants.POSITION_NOT_SET
import com.example.notekeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var notePosition = POSITION_NOT_SET

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val coursesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, DataManager.courses.values.toList())
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val coursesSpinner = findViewById<Spinner>(R.id.coursesSpinner)
        coursesSpinner.adapter = coursesAdapter

        //access the data sent from another activity
        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET) {
            displayNote(coursesSpinner)
        }
    }

    private fun displayNote(coursesSpinner: Spinner) {
        val note = DataManager.notes[notePosition]
        val title = findViewById<EditText>(R.id.titleText)
        val text = findViewById<EditText>(R.id.noteText)

        title.setText(note.title)
        text.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        coursesSpinner.setSelection(coursePosition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        val coursesSpinner = findViewById<Spinner>(R.id.coursesSpinner)
        ++notePosition
        displayNote(coursesSpinner)
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (notePosition >= DataManager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.block_white_24)
                menuItem.isEnabled = false
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}