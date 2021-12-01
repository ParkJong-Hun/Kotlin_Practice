package com.parkjonghun.sqlite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _data = MutableLiveData<List<String>>()
    val data:LiveData<List<String>> = _data

    fun getData():String {
        return if(data.value.isNullOrEmpty()) {
            ""
        } else {
            val length by lazy { data.value.toString().length - 1 }
            data.value.toString().substring(1, length)
        }
    }

    fun loadData() {

    }

    fun setData(text:String) {

    }

    fun deleteAllData() {

    }
}