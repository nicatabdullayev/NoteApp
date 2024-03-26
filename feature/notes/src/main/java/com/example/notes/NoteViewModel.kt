package com.example.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.repositories.NotesRepository

class NoteViewModel : ViewModel(){
    private val notesRepository : NotesRepository by lazy { NotesRepositoryImplementation() }
    private val _livedata = MutableLiveData<String>()
    val livedata : LiveData<String> = _livedata
}