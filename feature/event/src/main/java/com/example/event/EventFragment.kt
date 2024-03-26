package com.example.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.event.databinding.FragmentEventBinding



class EventFragment : Fragment() {

    private lateinit var binding: FragmentEventBinding
    val viewmodel by viewModels<EventViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEventBinding.inflate(inflater,container,false)
        return binding.root
    }
 }
