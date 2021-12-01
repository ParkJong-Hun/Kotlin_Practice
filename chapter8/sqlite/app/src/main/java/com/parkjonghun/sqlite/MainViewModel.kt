package com.parkjonghun.sqlite

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//Contextを使ってるViewModelだからAndroidViewModelで
class MainViewModel(application: Application): AndroidViewModel(application) {
    //Contextを持ってくる
    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext
    //Modelをインスタンス化（Signletone）
    private val db = MainModel.getInstance(context)!!

    //データの内容を返す
    fun getData():LiveData<List<MainEntity>> {
        return db.accessEntity().getAll()
    }

    //Modelから保管しているデータを持ってくる
    fun loadData() {
        db.accessEntity().getAll()
    }

    //データを追加
    fun setData(text:String) {
        val newData = MainEntity(text)
        //何かデータが変わるのは非同期で
        CoroutineScope(Dispatchers.IO).launch {
            db.accessEntity().insert(newData)
            db.accessEntity().getAll()
        }
    }

    //データを全部削除
    fun deleteAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            db.accessEntity().deleteAll()
            db.accessEntity().getAll()
        }
    }
}