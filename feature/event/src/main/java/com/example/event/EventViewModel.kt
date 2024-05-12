package com.example.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.BaseViewModel
import com.example.notes.NoteEffect
import com.example.notes.NoteEvent
import com.example.notes.NoteState

class EventViewModel : BaseViewModel<EventState, EventEffect, EventEvent>(){
    private val _livedata = MutableLiveData<String>()
    val livedata : LiveData<String> = _livedata
    override fun getInitialState() : EventState = EventState(isLoading = false)
}