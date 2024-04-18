package com.example.create_new

import com.example.domain.entity.entity.MyDataNote

data class CreateNewState(
    val isLoading: Boolean,
    val notesList: List<MyDataNote>? = null,
    val note: MyDataNote? = null
)