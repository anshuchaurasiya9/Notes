package com.anshu.notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.anshu.notes.Database.NotesDatabase
import com.anshu.notes.Model.Notes
import com.anshu.notes.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()
}


