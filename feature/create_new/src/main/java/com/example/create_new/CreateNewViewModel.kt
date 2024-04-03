package com.example.create_new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.entity.MyDataNote
import com.example.domain.entity.repositories.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateNewViewModel : ViewModel() {
    private val repository : NotesRepository by lazy { NotesRepositoryImplementation() }

    private val _livedata = MutableLiveData<String>()
    val livedata : LiveData<List<MyDataNote >> = repository.getNotesLists()

    fun saveNote(title: String, subtitle: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveNote(MyDataNote(title,subtitle,System.currentTimeMillis()))

        }
    }


}