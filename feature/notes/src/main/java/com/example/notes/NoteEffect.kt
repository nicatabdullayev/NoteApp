package com.example.notes

sealed class NoteEffect {
    object OnNoteAdded : NoteEffect()
}