package com.example.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.core.BaseViewModel
import com.example.data.notesrepositroy.NotesRepositoryImplementation
import com.example.domain.entity.repositories.NotesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel : BaseViewModel<SearchState, SearchEffect, SearchEvent>() {

    private val notesRepository: NotesRepository by lazy { NotesRepositoryImplementation() }

    override fun onEventUpdate(event: SearchEvent) {
        when (event) {
            is SearchEvent.GetNotes -> {
                notesRepository.getNotesListsRemote()
                    .onEach { currentDatabaseValue ->
                        setState(
                            getCurrentState()
                                .copy(notesList = currentDatabaseValue)
                        )
                    }.launchIn(viewModelScope)
            }

            is SearchEvent.FilterNote -> {
                filterList(event.text, event.list)
            }
        }
    }


    private fun filterList(text: String, list: MutableList<NoteResponseModel>) {
        var filteredList = list
        if (filteredList.any { it.title.startsWith(text) || it.subTitle.startsWith(text) })
            setState(
                getCurrentState().copy(
                    isLoading = false,
                    notesList = filteredList.filter {
                        it.title.startsWith(text) || it.subTitle.startsWith(
                            text
                        )
                    }
                )
            )
        else {
            setState(
                getCurrentState().copy(
                    isLoading = false,
                    notesList = list
                )
            )

            postEffect(SearchEffect.OnNotFoundNote)
        }
    }


    private val _livedata = MutableLiveData<String>()
//    val livedata: LiveData<List<MyDataNote>> = notesRepository.getNotesLists()


    override fun getInitialState(): SearchState = SearchState(isLoading = false)


}