package com.example.search

import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.domain.entity.entity.MyDataNote

data class SearchState(
    val isLoading: Boolean,
    val notesList: List<NoteResponseModel>? = null,
    val note: MyDataNote? = null
)