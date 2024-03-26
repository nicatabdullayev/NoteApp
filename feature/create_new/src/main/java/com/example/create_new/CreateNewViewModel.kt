package com.example.create_new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.repositories.NotesRepository

class CreateNewViewModel : ViewModel() {
    private val repository : NotesRepository by lazy { NotesRepositoryImplementation() }

    private val _livedata = MutableLiveData<String>()
    val livedata : LiveData<String> = _livedata

    fun saveNote(title: String, subtitle: String) {
        repository.saveNote(title,subtitle)
    }


}