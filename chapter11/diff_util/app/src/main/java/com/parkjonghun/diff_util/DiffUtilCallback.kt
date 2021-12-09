package com.parkjonghun.diff_util

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback(
    private val oldData: List<Any>,
    private val newData: List<Any>) : DiffUtil.Callback() {

    //以前リストの数を返す
    override fun getOldListSize(): Int = oldData.size
    //新しいリストの数を返す
    override fun getNewListSize(): Int = newData.size
    //二つのオブジェクトが同じ項目かどうか判断
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]

        return if (oldItem is String && newItem is String) {
            oldItem == newItem
        } else {
            false
        }
    }
    //二つの項目のデータが同じかどうか判断
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldData[oldItemPosition] == newData[newItemPosition]
    //もしareItemTheSame()がtrueを返してareContentsTheSame()がfalseを返したら下のメソッドを呼び出して変わった内容についてのPayLoadを持ってくる
    //    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
    //        return super.getChangePayload(oldItemPosition, newItemPosition)
    //    }
}