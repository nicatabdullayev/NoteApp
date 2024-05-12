package com.example.event

import com.example.domain.entity.entity.MyDataNote

data class EventState(
    val isLoading: Boolean,
    val notesList: List<MyDataNote>? = null,
    val note: MyDataNote? = null
)