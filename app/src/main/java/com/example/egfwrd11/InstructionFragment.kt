package com.example.egfwrd11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import com.example.egfwrd11.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        binding.next1.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,ShoeList(),ShoeList::class.java.simpleName).addToBackStack(null).commit()
            }
        }
        val callBack = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,WelcomeFragment(),WelcomeFragment::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        return binding.root
    }

}