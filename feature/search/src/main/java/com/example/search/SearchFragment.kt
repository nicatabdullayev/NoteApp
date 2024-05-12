package com.example.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.core.BaseFragment
import com.example.core.ToolbarManager

import com.example.search.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel, SearchState, SearchEffect, SearchEvent>() {

    private lateinit var adapter: SearchAdapter
    private var noteList: MutableList<NoteResponseModel> = mutableListOf()
    override val getViewBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchBinding =
        { inflater, viewGroup, value ->
            FragmentSearchBinding.inflate(inflater, viewGroup, value)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postEvent(SearchEvent.GetNotes)
        (requireContext() as ToolbarManager).setTitle("Search")
        adapter = SearchAdapter()
        binding.notesList.adapter = adapter
        searchAction()
        // bring mydatanotes from viewmodel and assign it to list value
    }

    override fun getViewModelClass() = SearchViewModel::class.java

    override fun onStateUpdate(state: SearchState) {
        when {
            state.isLoading -> {

            }

            else -> {
                if (state.notesList != null) {
                    adapter.submitList(state.notesList.toMutableList())
                    noteList = state.notesList.toMutableList()
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onEffectUpdate(effect: SearchEffect) = when (effect) {
        is SearchEffect.OnNotFoundNote -> {
            Toast.makeText(requireContext(), "Searched file not found", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun searchAction() {
        binding.editTextText.doOnTextChanged { text, start, before, count ->
            if (!text.isNullOrEmpty())
                postEvent(SearchEvent.FilterNote(text.toString(), noteList))
            else
                postEvent(SearchEvent.GetNotes)
        }
    }
}