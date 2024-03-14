package com.example.logregapp.navigation_fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.logregapp.R
import com.example.logregapp.databinding.FragmentLoginBinding
import com.example.logregapp.databinding.FragmentRegisterBinding

class LoginFragment : Fragment() {

   lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navLogToReg = LoginFragmentDirections.actionLoginFragmentToDashBoardFragment(getUserName())
        binding.signInLogin.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
        binding.loginBtn.setOnClickListener {
        val email = binding.loginEmailInput.text.toString()
        val password = binding.loginPassInput.text.toString()

            if (checkerUser(email,password)){
                findNavController().navigate(navLogToReg)
            }else{
                showAlertDialogForLogin()
            }
        }
    }
    private fun getUserName():String?{
            val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val userName = sharedPreferences.getString("Name",null)
        return userName
    }
    private fun checkerUser(email:String,password:String):Boolean{
        val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("Email",null)
        val savedPassword = sharedPreferences.getString("Password", null)
        return savedEmail==email && savedPassword==password
    }
    private fun showAlertDialogForLogin() {
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage("Invalid email or password")
            .setPositiveButton("OK", null)
            .setCancelable(false)
            .show()
    }
}

