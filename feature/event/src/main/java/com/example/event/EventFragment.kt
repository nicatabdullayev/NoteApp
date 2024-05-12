package com.example.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.core.BaseFragment
import com.example.core.ToolbarManager
import com.example.event.EventViewModel
import com.example.event.databinding.FragmentEventBinding
import com.example.notes.NoteEffect
import com.example.notes.NoteEvent
import com.example.notes.NoteState
import com.example.notes.NoteViewModel
import com.example.notes.databinding.FragmentNotesBinding
import com.example.search.SearchAdapter
import com.example.event.EventViewModel as EventViewModel1


class EventFragment : BaseFragment<FragmentEventBinding, EventViewModel, EventState , EventEffect, EventEvent>()  {

    private lateinit var adapter: EventAdapter
    private var noteList: MutableList<NoteResponseModel> = mutableListOf()
//    private lateinit var binding: FragmentEventBinding
    override val getViewBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEventBinding= { inflater, viewGroup, value ->
    FragmentEventBinding.inflate(inflater, viewGroup, value)
}

//    val viewmodel by viewModels<EventViewModel1>()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext() as ToolbarManager).setTitle("Event")
        adapter = EventAdapter()
        binding.eventList.adapter = adapter

    }

    override fun getViewModelClass() = EventViewModel::class.java

}
