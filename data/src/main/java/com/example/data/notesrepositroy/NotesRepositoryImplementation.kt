package com.example.data.notesrepositroy

import androidx.lifecycle.LiveData
import com.example.data.notesrepositroy.database.DatabaseManager
import com.example.domain.entity.entity.MyDataNote
import com.example.domain.entity.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImplementation : NotesRepository {
    override fun addNote(note: MyDataNote) {

    }

    override fun saveNote(note: MyDataNote) {
        return DatabaseManager.database.notesDao().insert(note)

    }

    override fun getNotesLists(): Flow<List<MyDataNote>> {
        return DatabaseManager.database.notesDao().getAll()
    }
}