package com.example.myapplication

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            val activityIntent = Intent( this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        binding.listNote.adapter = ArrayAdapter(this,
        R.layout.simple_list_item_1,
        DataManager.notes)

        binding.listNote.setOnItemClickListener {parent, view, position, id->
            val activityIntent = Intent( this, MainActivity::class.java)
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activityIntent)
        }

    }

}