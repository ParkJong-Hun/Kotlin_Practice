package com.parkjonghun.sqlite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//テーブルを利用して作業できるオブジェクト
@Dao
interface MainDao {
    //質疑問
    @Query("SELECT * FROM Entity")
    fun getAll(): LiveData<List<MainEntity>>
    @Query("DELETE FROM Entity")
    fun deleteAll()
    @Insert
    fun insert(text:MainEntity)
}