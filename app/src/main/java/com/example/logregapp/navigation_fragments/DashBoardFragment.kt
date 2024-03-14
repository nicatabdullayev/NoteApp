package com.example.logregapp.navigation_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.logregapp.R
import com.example.logregapp.databinding.FragmentDashBoardBinding
import com.example.logregapp.databinding.FragmentLoginBinding


class DashBoardFragment : Fragment() {
    val arguments by navArgs<DashBoardFragmentArgs>()

    lateinit var binding: FragmentDashBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDashBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = arguments.userName
        binding.welcomeTextDashboard.setText( "Welcome $username")
    }

//    private fun textViewForUserName():String{
//        val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
//        val savedFullName = sharedPreferences.getString("Name",null)
//        return "Welcome $savedFullName"
//    }
}
