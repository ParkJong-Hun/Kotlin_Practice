package com.parkjonghun.diff_util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val list: MutableLiveData<List<String>> = MutableLiveData()
    private val _list: MutableList<String> = mutableListOf("0", "2", "3213d")
    val listData: LiveData<List<String>> = list

    init {
        list.value = _list
    }

    fun getData(): LiveData<List<String>> {
        return listData
    }

    fun addData(data:String) {
        _list.add(data)
        list.value = _list
    }
}