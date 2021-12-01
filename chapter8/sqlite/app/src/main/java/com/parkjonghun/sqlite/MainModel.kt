package com.parkjonghun.sqlite

import android.content.Context
import androidx.room.*

//Entityを含めるデータベース
@Database(entities = [MainEntity::class], version = 1)
abstract class MainModel: RoomDatabase() {
    abstract fun accessEntity(): MainDao
    //インスタンス化
    companion object {
        var instance: MainModel? = null
        @Synchronized
        fun getInstance(context: Context): MainModel? {
            if(instance == null) {
                synchronized(MainModel::class) {
                    instance = Room.databaseBuilder(
                        context,
                        MainModel::class.java,
                        "database")
                        .build()
                }
            }
            return instance!!
        }
    }
}
