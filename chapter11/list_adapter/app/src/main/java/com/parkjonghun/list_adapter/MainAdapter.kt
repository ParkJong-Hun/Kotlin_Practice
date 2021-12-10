package com.parkjonghun.list_adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.parkjonghun.list_adapter.databinding.ItemRecylcerviewBinding

//ListAdapterとは既存Adapterを改善するために使ったDiffUtilを含めてるAdapterと思えばいい。
//つまりAdapterの中でなんかDiffUtilオブジェクトを作らなくても最初作業したことでAdpaterそのものでDiffUtilのメソッドを使うことができる。
//自分のRepositoryのChapter11のDiffUtilを見てこれを見ると確かにこれのほうが簡単になったってことがわかる。
//class　Adapter名前：ListAdapter＜Model,ViewHolder＞（DiffUtil.ItemCallback）
class MainAdapter: ListAdapter<MainData, MainAdapter.MainViewHolder>(DiffCallback()) {

    inner class MainViewHolder(private val binding: ItemRecylcerviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data:MainData) {
            binding.itemRecyclerview.text = data.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemRecylcerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

//ListAdapterに使うために作るDiffCallback
class DiffCallback: DiffUtil.ItemCallback<MainData>() {
    override fun areItemsTheSame(oldItem: MainData, newItem: MainData): Boolean =
        oldItem?.text == newItem?.text

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MainData, newItem: MainData): Boolean =
        oldItem == newItem
}