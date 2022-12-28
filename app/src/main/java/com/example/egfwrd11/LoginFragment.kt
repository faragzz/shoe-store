package com.example.egfwrd11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.egfwrd11.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var communicator: Communicator1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        communicator = activity as Communicator1
        binding.login.setOnClickListener{
                val input : String = Name.text.toString()
                communicator.passData(input)
        }
        binding.signin.setOnClickListener {
            login.setOnClickListener {
                val input: String = Name.text.toString()
                communicator.passData(input)
            }
        }
        return binding.root

    }
}
