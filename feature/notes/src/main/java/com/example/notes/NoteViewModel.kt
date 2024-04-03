package com.example.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.entity.MyDataNote
import com.example.domain.entity.repositories.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel(){
    private val notesRepository : NotesRepository by lazy { NotesRepositoryImplementation() }
    private var _livedata = notesRepository.getNotesLists()
    val livedata : LiveData<List<MyDataNote>> = _livedata

}