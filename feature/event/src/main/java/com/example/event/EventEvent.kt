package com.example.event

sealed class EventEvent {
    data class AddEvent(val title: String, val subTitle: String) : EventEvent()
}