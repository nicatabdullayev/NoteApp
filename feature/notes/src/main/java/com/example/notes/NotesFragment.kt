package com.example.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.BaseFragment
import com.example.core.ToolbarManager
//import com.example.logregapp.navigation_fragments.ToolbarManager
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.note_list.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class NotesFragment : BaseFragment<FragmentNotesBinding, NoteViewModel, NoteState, NoteEffect, NoteEvent>() {

    private lateinit var adapter: NotesAdapter
    override fun getViewModelClass() = NoteViewModel::class.java

    override val getViewBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNotesBinding = { inflater, viewGroup, value ->
        FragmentNotesBinding.inflate(inflater, viewGroup, value)
    }

    override fun onStateUpdate(state: NoteState) {
        state.notesList?.let { list->
            adapter.submitList(list)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext() as ToolbarManager).setTitle("Notes")
        adapter = NotesAdapter()
        binding.notesList.adapter = adapter

//        viewmodel.livedata.observe(viewLifecycleOwner) { list ->
//            adapter.submitList(list)
//
//
//    }






//    private fun textViewForUserName():String{
//        val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
//        val savedFullName = sharedPreferences.getString("Name",null)
//        return "Welcome $savedFullName"
//    }

}}
