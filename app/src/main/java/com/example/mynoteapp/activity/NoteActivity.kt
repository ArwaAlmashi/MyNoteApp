package com.example.mynoteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.mynoteapp.database.DatabaseHelper
import com.example.mynoteapp.databinding.ActivityNoteBinding
import com.example.mynoteapp.lightStatueBar
import com.example.mynoteapp.model.Note
import com.example.mynoteapp.model.NoteModel
import com.example.mynoteapp.model.Task
import com.example.mynoteapp.recyclerview.NotesAdapter
import com.example.mynoteapp.recyclerview.RecentNotesAdapter
import com.example.mynoteapp.setFullScreen

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    private lateinit var recentlyNotesRV: RecyclerView
    private lateinit var recentlyNotesAdapter: RecentNotesAdapter

    private lateinit var notesRV: RecyclerView
    private lateinit var notesAdapter: NotesAdapter

    private lateinit var notes: ArrayList<NoteModel>

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set UI
        setFullScreen(window)
        lightStatueBar(window)

        // Get All Note
        notes = databaseHelper.readData()

        // Set Recyclerview
        setRecyclerview()

        // Go to Add Note
        binding.addIcon.setOnClickListener {
            val intent = Intent(this, AddNewNoteActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setRecyclerview() {
        notesRV = binding.allNotesRecyclerview
        notesAdapter = NotesAdapter(notes, this)
        notesRV.adapter = notesAdapter
    }

}