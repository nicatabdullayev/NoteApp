package com.example.create_new

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelStore
import com.example.core.BaseFragment
import com.example.core.ToolbarManager
import com.example.create_new.databinding.FragmentCreateNoteBinding
import com.example.notes.databinding.FragmentNotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class CreateNoteFragment : BaseFragment<FragmentCreateNoteBinding, CreateNewViewModel, CreateNewState, CreateNewEffect, CreateNewEvent>() {
//    val viewmodel by viewModels<CreateNewViewModel>()


    override val getViewBinding: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCreateNoteBinding = { inflater, viewGroup, value ->
        FragmentCreateNoteBinding.inflate(inflater, viewGroup, value)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener{
            viewModel.postEvent(
                CreateNewEvent.AddNote(
                    binding.title.text.toString(),
                    binding.subtitle.text.toString()
                )
            )
        }
//        viewmodel.livedata.observe(viewLifecycleOwner){
//
//        }
        (requireContext() as ToolbarManager).setTitle("Create Note ")

    }

    override fun getViewModelClass() = CreateNewViewModel::class.java

//    override fun onStateUpdate(state: CreateNewState) {
//
//    }

    override fun onEffectUpdate(effect: CreateNewEffect) {
        when (effect) {
            CreateNewEffect.OnNoteAdded -> Toast.makeText(requireContext(), "Note Added", Toast.LENGTH_SHORT).show()
        }
    }
}



