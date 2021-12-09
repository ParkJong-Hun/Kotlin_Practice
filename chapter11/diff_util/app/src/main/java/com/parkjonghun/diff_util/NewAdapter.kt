package com.parkjonghun.diff_util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.parkjonghun.diff_util.databinding.ItemRecylcerviewBinding

class NewAdapter(): RecyclerView.Adapter<NewAdapter.ViewHolder>() {
    //ValueBindingするためにViewHolderをこう作成
    inner class ViewHolder(private val binding: ItemRecylcerviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data:String) {
            binding.itemText.text = data
        }
    }

    //NewAdapterみたいにClassを新しく書かなくて簡単に書いたオブジェクト
    private val differCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    //DifferCallBackを使ってデータを管理するオブジェクト
    val differ = AsyncListDiffer<String>(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Bindingをインフレーター
        val binding = ItemRecylcerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}