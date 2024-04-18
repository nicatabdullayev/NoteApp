package com.example.create_new

sealed class CreateNewEvent {
    data class AddNote(val title: String, val subTitle: String) : CreateNewEvent()
}