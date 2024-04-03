package com.example.domain.entity.repositories

import androidx.lifecycle.LiveData
import com.example.domain.entity.entity.MyDataNote

interface NotesRepository {
    fun addNote(note:MyDataNote)

    fun saveNote(note:MyDataNote)
    fun getNotesLists() : LiveData<List<MyDataNote>>
}