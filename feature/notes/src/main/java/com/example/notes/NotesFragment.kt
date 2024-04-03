package com.example.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.core.ToolbarManager
//import com.example.logregapp.navigation_fragments.ToolbarManager
import com.example.notes.databinding.FragmentNotesBinding


class NotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding
    val viewmodel by viewModels<NoteViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext() as ToolbarManager).setTitle("Notes")


    }

//    private fun textViewForUserName():String{
//        val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
//        val savedFullName = sharedPreferences.getString("Name",null)
//        return "Welcome $savedFullName"
//    }
}
