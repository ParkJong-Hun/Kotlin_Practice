package com.parkjonghun.sqlite

import android.content.Context
import androidx.room.*

//Entityを含めるデータベース
@Database(entities = [MainEntity::class], version = 1, exportSchema = false)
abstract class MainModel: RoomDatabase() {
    abstract fun accessEntity(): IEntityAccess
    companion object {
        private var instance: MainModel? = null
        @Synchronized
        fun getInstance(context: Context): MainModel {
            if(instance == null) {
                synchronized(MainModel::class) {
                    instance = Room.databaseBuilder(
                        context,
                        MainModel::class.java, //파일경로).build()
                    )
                }
            }
            return instance!!
        }
    }
}

//テーブルを利用して作業できるオブジェクト
@Dao
interface IEntityAccess {
    //質疑問
    @Query("SELECT * FROM Entity")
    fun select(): List<MainEntity>
}