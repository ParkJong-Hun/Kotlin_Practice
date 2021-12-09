package com.parkjonghun.diff_util

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.parkjonghun.diff_util.databinding.ActivityMainBinding

//DiffUtilとはoldListとnewListの違いを計算してoldListをnewListに変換するアップデート作業目録をプリントできるClass。
//アップデート作業目録はInsert、Remove、Updateがある
//既存のAdapterはデータが変わった時notifySetChangedを呼び出さないといけなかったDiffUtilのおかげでもっと効率的に管理ができた。
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm: MainViewModel by viewModels()

        //RecyclerView設定
        val layoutManager = LinearLayoutManager(this)
        binding.recylcerView.layoutManager = layoutManager
        val adapter = NewAdapter()

        //DiffUtilを使ってアップデート
        vm.listData.observe(this, Observer {
            binding.recylcerView.adapter = adapter
            adapter.differ.submitList(it)
        })

        binding.button.setOnClickListener{
            vm.addData(binding.editText.text.toString())
            binding.editText.text.clear()
        }
    }
}