package com.example.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.repositories.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
@HiltViewModel
class NoteViewModel : BaseViewModel<NoteState, NoteEffect, NoteEvent>() {
    private val notesRepository : NotesRepository by lazy { NotesRepositoryImplementation() }
    init {
        notesRepository.getNotesLists()
            .onEach { currentDatabaseValue ->
                setState(
                    getCurrentState()
                        .copy(
                            notesList = currentDatabaseValue
                        )
                )
            }.launchIn(viewModelScope)
    }




    private val _livedata = MutableLiveData<String>()
//    val livedata: LiveData<List<MyDataNote>> = notesRepository.getNotesLists()


    override fun getInitialState(): NoteState = NoteState(isLoading = false)

}