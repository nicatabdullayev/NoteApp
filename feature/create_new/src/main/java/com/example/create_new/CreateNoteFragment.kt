package com.example.create_new

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.create_new.databinding.FragmentCreateNoteBinding


class CreateNoteFragment : Fragment() {
    private lateinit var binding: FragmentCreateNoteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCreateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

}



