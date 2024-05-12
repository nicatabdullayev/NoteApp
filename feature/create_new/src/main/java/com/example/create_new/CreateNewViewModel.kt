package com.example.create_new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.entity.MyDataNote
import com.example.domain.entity.repositories.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
@HiltViewModel
class CreateNewViewModel : BaseViewModel<CreateNewState, CreateNewEffect, CreateNewEvent>() {
    private val repository : NotesRepository by lazy { NotesRepositoryImplementation() }

    init {
        repository.getNotesLists()
            .onEach { currentDatabaseValue ->
                setState(
                    getCurrentState()
                        .copy(
                            notesList = currentDatabaseValue
                        )
                )
            }.launchIn(viewModelScope)
    }

    override fun onEventUpdate(event: CreateNewEvent) {
        when (event) {
            is CreateNewEvent.AddNote -> saveNote(
                event.title, event.subTitle
            )
        }
    }

    private val _livedata = MutableLiveData<String>()
//    val livedata : LiveData<List<MyDataNote >> = repository.getNotesLists()

    fun saveNote(title: String, subtitle: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveNote(MyDataNote(title,subtitle,System.currentTimeMillis()))

        }
    }

    override fun getInitialState(): CreateNewState = CreateNewState(isLoading = false)



}