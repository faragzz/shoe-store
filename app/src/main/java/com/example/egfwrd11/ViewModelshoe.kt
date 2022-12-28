package com.example.egfwrd11

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import kotlin.collections.List

class ViewModelshoe : ViewModel() {
    private val _listData: MutableLiveData<List<String>> = MutableLiveData(emptyList())
    val listData: LiveData<List<String>> = _listData

    fun addData(x:String){
        val iztem  = x
        _listData.value = _listData.value?.plus(item) ?: listOf(item)
    }


    fun getData(): MutableLiveData<List<String>> {
        return _listData
    }


}


