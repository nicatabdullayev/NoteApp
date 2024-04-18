package com.example.notes

sealed class NoteEvent {
    data class AddNote(val title: String, val subTitle: String) : NoteEvent()
}