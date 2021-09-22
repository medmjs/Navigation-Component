package com.example.navigationcomponentapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentapplication.databinding.ProfileFragmentBinding

class ProfileFragment :Fragment() {

    lateinit var binding:ProfileFragmentBinding
     val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvProName.text = args.username
        binding.tvProPass.text = args.password


        binding.btnProContent.setOnClickListener {

        }
    }








}