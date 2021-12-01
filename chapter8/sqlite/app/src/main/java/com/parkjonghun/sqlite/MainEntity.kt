package com.parkjonghun.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity

//テーブルの情報（SQLiteに表示）
@Entity(tableName = "Entity", primaryKeys = ["text"])
//Kotlinで表示
class MainEntity(
    //フィールドの情報
    @ColumnInfo(name = "text", typeAffinity = ColumnInfo.TEXT)
    val id: String
) {
    //...
}