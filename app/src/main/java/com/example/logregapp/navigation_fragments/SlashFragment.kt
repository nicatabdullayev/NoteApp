package com.example.logregapp.navigation_fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.logregapp.R
import com.example.logregapp.databinding.FragmentSlashBinding

class SlashFragment : Fragment() {
    lateinit var binding: FragmentSlashBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentSlashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGetStarted.setOnClickListener {

//            findNavController().navigate(R.id.registerFragment)

            val sharedPreferences = requireContext().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
            if(sharedPreferences.getBoolean("hasCompletedSetup",true)){
                findNavController().navigate(R.id.registerFragment)
                sharedPreferences.edit().putBoolean("hasCompletedSetup", false).apply()
            }else{
                findNavController().navigate(R.id.action_slashFragment_to_loginFragment)

            }
        }
    }

}



