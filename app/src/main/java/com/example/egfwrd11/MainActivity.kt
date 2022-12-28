package com.example.egfwrd11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.egfwrd11.databinding.ActivityMainBinding

class MainActivity() : AppCompatActivity(),Communicator1,ShoeDetailTransfer{

    lateinit var binding: ActivityMainBinding
    var x:MutableList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,LoginFragment()).commit()
    }

    override fun passData(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("data",editTextInput)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentWel = WelcomeFragment()
        fragmentWel.arguments = bundle

// Navigate using the IDs you defined in your Nav Graph
//        navController.navigate(R.id.towelcome)
        transaction.replace(R.id.fragmentContainerView,fragmentWel).commit()
    }

    override fun ShoeData(name: String, comp: String, size: String, desc: String) {
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("comp",comp)
        bundle.putString("size",size)
        bundle.putString("desc",desc)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentDet = Details()
        fragmentDet.arguments = bundle
        transaction.replace(R.id.fragmentContainerView,fragmentDet).commit()
    }


}