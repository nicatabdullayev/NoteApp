package com.example.create_new

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.create_new.databinding.FragmentCreateNoteBinding


class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding
    val viewmodel by viewModels<CreateNewViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener{
            val title = binding.title.toString()
            val subtitle = binding.subtitle.toString()
            viewmodel.saveNote(title,subtitle)
        }
    }
}



