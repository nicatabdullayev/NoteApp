package com.example.domain.entity.repositories

import androidx.lifecycle.LiveData
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.domain.entity.entity.MyDataNote
import java.util.concurrent.Flow

interface NotesRepository {
    fun addNote(note:MyDataNote)

    fun saveNote(note:MyDataNote)
    fun getNotesLists() : kotlinx.coroutines.flow.Flow<List<MyDataNote>>

    fun getNotesListsRemote() : kotlinx.coroutines.flow.Flow<List<NoteResponseModel>>
}