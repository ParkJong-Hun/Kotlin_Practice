package com.parkjonghun.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //追加、削除のためのリスト
    private val usersList:MutableList<String> = mutableListOf<String>()

    //監視されるLiveData（リストの値を持ってくる）
    private val _users: MutableLiveData<List<String>> = MutableLiveData<List<String>>()

    //_usersの内容のリード専用のLiveData
    val users:LiveData<List<String>> = _users

    //最初
    init {
        _users.value = usersList
    }

    //データをリストに追加
    fun setUsers(name:String) {
        if(name.isNotEmpty()) {
            usersList.add(name).also {
                _users.value = usersList
                Log.d("data", users.value.toString())
            }
        }
    }

    //ユーザーが綺麗に見るためのデータ加工関数
    fun getUsersToString(): String {
        return if (users.value.toString() == "[]") {
            ""
        } else {
            users.value.toString().substring(1, users.value.toString().length - 1)
        }
    }
}