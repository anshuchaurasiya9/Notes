package com.anshu.notes.Repository

import androidx.lifecycle.LiveData
import com.anshu.notes.Dao.NotesDao
import com.anshu.notes.Database.NotesDatabase
import com.anshu.notes.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}