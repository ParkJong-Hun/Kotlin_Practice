package com.parkjonghun.list_adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    //MainDataというModelを使ったLiveData
    private val mutableData: MutableList<MainData> = mutableListOf()
    private val _data: MutableLiveData<List<MainData>> = MutableLiveData()
    val data:LiveData<List<MainData>> = _data

    init {
        _data.value = mutableData
    }

    fun addDataOnList(data:String) {
        if(data.isNotEmpty()) {
            val newData = MainData(data)
            mutableData.add(newData)
            _data.value = mutableData
        }
    }
}