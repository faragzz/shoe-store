package com.example.egfwrd11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.egfwrd11.databinding.FragmentDetailsBinding
import com.example.egfwrd11.databinding.FragmentListBinding
import kotlin.collections.List
import kotlin.properties.ReadOnlyProperty

class List<T> : Fragment() {
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var binding: FragmentListBinding
    private val viewModel by activityViewModels<ViewModelshoe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        putStringArrayList
        // Inflate the layout for this fragment

//        viewModel = ViewModelProvider(this).get(ViewModelshoe::class.java)

        binding = FragmentListBinding.inflate(inflater, container, false)

        viewModel.getData().observe(viewLifecycleOwner, Observer {
            getData(it)
        })


        binding.back.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView,ShoeList(),ShoeList::class.java.simpleName).addToBackStack(null).commit()
            }
        }


        val callBack = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,Details(),Details::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        return binding.root
    }

    private fun getData(data: List<String>?) {
        try {
            arrayAdapter = activity?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_list_item_1,
                    ArrayList(data)
                    )
            }!!
            binding.listView.adapter = arrayAdapter
        }
        catch (e:Exception){
            println("ok mashy")
        }
    }



}

