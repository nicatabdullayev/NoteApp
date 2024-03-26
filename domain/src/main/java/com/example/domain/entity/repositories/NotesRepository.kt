package com.example.domain.entity.repositories

import com.example.domain.entity.entity.MyDataNote

interface NotesRepository {
    fun addNote(note:MyDataNote)

    fun saveNote(title:String,subtitle:String)
}