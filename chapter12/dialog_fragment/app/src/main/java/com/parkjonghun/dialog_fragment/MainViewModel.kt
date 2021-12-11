package com.parkjonghun.dialog_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _list:MutableList<String> = mutableListOf()
    private val ml_list:MutableLiveData<List<String>> = MutableLiveData()
    val list: LiveData<List<String>> = ml_list

    fun addData(data:String) {
        _list.add(data)
        ml_list.value = _list
    }
}