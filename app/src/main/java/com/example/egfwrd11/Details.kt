package com.example.egfwrd11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.egfwrd11.databinding.FragmentDetailsBinding

class Details : Fragment() {
    lateinit var viewdataList:MainActivity
    lateinit var binding: FragmentDetailsBinding
    private val viewModel by activityViewModels<ViewModelshoe>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        viewModel = ViewModelProvider(this).get(ViewModelshoe::class.java)

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.cancel.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,ShoeList(),ShoeList::class.java.simpleName).addToBackStack(null).commit()
            }
        }

        binding.save.setOnClickListener {
            val name = binding.shoename1.text.toString()
            val comp = binding.shoeComp1.text.toString()
            val size = binding.shoesize1.text.toString()
            val desc = binding.shoeDesc1.text.toString()
            println(name)
            viewModel.addData(name)
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,List<Any>(),List::class.java.simpleName).addToBackStack(null).commit()
            }
        }
        val callBack = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,ShoeList(),ShoeList::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        return binding.root
    }

}