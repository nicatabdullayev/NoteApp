package com.example.logregapp.navigation_fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.logregapp.R
import com.example.logregapp.databinding.FragmentRegisterBinding
import com.example.logregapp.databinding.FragmentSlashBinding


class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signIn.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.btnRegister.setOnClickListener {
            val fullName = binding.fullnameInput.text.toString()
            val email = binding.emailAddressInput.text.toString()
            val password = binding.enterPassInput.text.toString()
            if (binding.confirmPassInput.text.isEmpty() || binding.enterPassInput.text.isEmpty() || binding.fullnameInput.text.isEmpty()|| binding.emailAddressInput.text.isEmpty() ){
                showAlertDialogForImputs()
            }else{
                if (binding.enterPassInput.getText().toString() == binding.confirmPassInput.getText().toString() && saveUserData(fullName, email, password) ){

                    findNavController().navigate(R.id.action_registerFragment_to_dashBoardFragment)
                }else{
                    showAlertDialogForConfirmPass()
                }
            }


//            if (saveUserData(fullName, email, password)) {
//                findNavController().navigate(R.id.action_registerFragment_to_dashBoardFragment)
//            } else {
//                Toast.makeText(requireContext(), "Failed to save user data", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    private fun saveUserData(name: String, email: String, password: String): Boolean {
        val sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("Name", name)
        editor.putString("Email", email)
        editor.putString("Password", password)

        return editor.commit()
    }

    private fun showAlertDialogForImputs() {
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("Empty Blank")
            .setMessage("Feel free to fill in the blanks")
            .setCancelable(false)
            .setPositiveButton("Ok") { _, _ ->

            }

            .show()
    }

    private fun showAlertDialogForConfirmPass() {
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("False Pass")
            .setMessage("Your pass is not same")
            .setCancelable(false)
            .setPositiveButton("Ok") { _, _ ->

            }

            .show()
    }

}

