package com.example.navigationcomponentapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentapplication.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding
    val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginDeepLink = args.username
        binding.etLoginUsername.setText(loginDeepLink)

        binding.btnLoginConfirm.setOnClickListener {

            var userName = binding.etLoginUsername.text.toString()
            var password = binding.etLoginPass.text.toString()

            var action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(userName,password)
            findNavController().navigate(action)

        }








    }

}