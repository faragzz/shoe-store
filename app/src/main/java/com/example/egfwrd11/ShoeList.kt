package com.example.egfwrd11

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ShoeList : Fragment() {
    lateinit var f1: FloatingActionButton
    lateinit var f2: FloatingActionButton
    lateinit var f3: FloatingActionButton
    lateinit var f4: FloatingActionButton
    lateinit var f5: FloatingActionButton
    lateinit var f6: FloatingActionButton
    lateinit var f7: FloatingActionButton
    lateinit var f8: FloatingActionButton
    lateinit var f9: FloatingActionButton
    lateinit var f10: FloatingActionButton
    lateinit var f11: FloatingActionButton
    lateinit var f12: FloatingActionButton
    lateinit var name: String
    lateinit var comp: String
    lateinit var size: String
    lateinit var description: String
    private lateinit var shoeDetailsTranfer:ShoeDetailTransfer

    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shoe_list, container, false)

        f1 = view.findViewById(R.id.f1)
        f2 = view.findViewById(R.id.f2)
        f3 = view.findViewById(R.id.f3)
        f4 = view.findViewById(R.id.f4)
        f5 = view.findViewById(R.id.f5)
        f6 = view.findViewById(R.id.f6)
        f7 = view.findViewById(R.id.f7)
        f8 = view.findViewById(R.id.f8)
        f9 = view.findViewById(R.id.f9)
        f10 = view.findViewById(R.id.f10)
        f11 = view.findViewById(R.id.f11)
        f12 = view.findViewById(R.id.f12)

        shoeDetailsTranfer = activity as ShoeDetailTransfer

        f1.setOnClickListener {
            name = "Redshoe"
            comp = "Nike"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Red"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f2.setOnClickListener {
            name = "blue Shoe"
            comp = "V"
            size = "8 to 10"
            description = "type: Sport shoe\nColor: Blue"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }

        f3.setOnClickListener {
            name = "Grey Shoe"
            comp = "Send"
            size = "7 to 12"
            description = "type: Sport shoe\nColor: Grey"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f4.setOnClickListener {
            name = "white shoe"
            comp = "Star"
            size = "7 to 12"
            description = "type: Boot shoe\nColor: White"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }

        f5.setOnClickListener {
            name = "Grey shoe"
            comp = "ON"
            size = "7 to 10"
            description = "type: Classic shoe\nColor: Grey with Brown touch"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f6.setOnClickListener {
            name = "Brown shoe"
            comp = "Sec"
            size = "7 to 10"
            description = "type: Classic shoe\nColor: Brown"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f7.setOnClickListener {
            name = "3stripes"
            comp = "Adidas"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Black and White"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f8.setOnClickListener {
            name = "Nature"
            comp = "waves"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Nature colors"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f9.setOnClickListener {
            name = "Black on Black"
            comp = "24 seven"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Black"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f10.setOnClickListener {
            name = "black Cheetah"
            comp = "Z"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Black"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)

        }
        f11.setOnClickListener {
            name = "Phenix "
            comp = "IO"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Black with yellow splash"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        f12.setOnClickListener {
            name = "Military"
            comp = "Adidas"
            size = "7 to 10"
            description = "type: Sport shoe\nColor: Military"
            shoeDetailsTranfer.ShoeData(name,comp,size,description)
        }
        setHasOptionsMenu(true)
        val callBack = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,InstructionFragment(),InstructionFragment::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callBack)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout ->{
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragmentContainerView,LoginFragment(),LoginFragment::class.java.simpleName).addToBackStack(null).commit()
                }
            }
        }
        return true
    }
}