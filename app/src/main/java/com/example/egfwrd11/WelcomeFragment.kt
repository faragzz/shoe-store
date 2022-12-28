package com.example.egfwrd11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.egfwrd11.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    var message :String?=""
    lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        
        message = arguments?.getString("data")
        binding.textView4.setText(message)

        binding.next.setOnClickListener{
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,InstructionFragment(),InstructionFragment::class.java.simpleName).addToBackStack(null).commit()
            }
        }
        val callBack = object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,LoginFragment(),LoginFragment::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)

        return binding.root
    }
    

}