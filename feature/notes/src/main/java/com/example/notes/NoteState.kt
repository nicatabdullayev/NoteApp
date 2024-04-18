package com.example.notes

import com.example.domain.entity.entity.MyDataNote

data class NoteState(
    val isLoading: Boolean,
    val notesList: List<MyDataNote>? = null,
    val note: MyDataNote? = null
)