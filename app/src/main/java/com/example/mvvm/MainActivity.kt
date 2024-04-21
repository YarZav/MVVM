package com.example.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.database.NoteDatabase
import com.example.mvvm.repositories.NoteRepository
import com.example.mvvm.viewmodels.NoteViewModel
import com.example.mvvm.viewmodels.NoteViewModelFactory

class MainActivity : ComponentActivity() {

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel() {
        val noteDatabase = NoteDatabase(this)
        val noteRepository = NoteRepository(noteDatabase)
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory)[NoteViewModel::class.java]
    }
}