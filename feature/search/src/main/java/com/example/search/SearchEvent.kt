package com.example.search

import com.abbtech.domain.entities.response_models.NoteResponseModel

sealed class SearchEvent {
    data object GetNotes : SearchEvent()

    data class FilterNote(var text: String, var list: MutableList<NoteResponseModel>) : SearchEvent()
}