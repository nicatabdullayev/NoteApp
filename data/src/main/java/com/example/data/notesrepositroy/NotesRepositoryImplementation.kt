package com.example.data.notesrepositroy

import androidx.lifecycle.LiveData
import com.abbtech.data.api.NetworkManager
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.data.notesrepositroy.database.DatabaseManager
import com.example.domain.entity.entity.MyDataNote
import com.example.domain.entity.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImplementation : NotesRepository {
    override fun addNote(note: MyDataNote) {

    }

    override fun saveNote(note: MyDataNote) {
        return DatabaseManager.database.notesDao().insert(note)

    }

    override fun getNotesLists(): Flow<List<MyDataNote>> {
        return DatabaseManager.database.notesDao().getAll()
    }

    override fun getNotesListsRemote(): Flow<List<NoteResponseModel>> = flow {
        emit(NetworkManager.getNotesServiceInstance().getAllNotes())
    }
}