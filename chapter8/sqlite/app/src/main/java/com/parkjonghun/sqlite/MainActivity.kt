package com.parkjonghun.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.parkjonghun.sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ActivityViewModelを使うときオブジェクトを持ってくる
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //データをロード
        viewModel.loadData()

        //データ追加
        binding.addButton.setOnClickListener{
            val newData = binding.addEditText.text.toString()
            if(newData.isNotEmpty()) {
                viewModel.setData(newData)
            } else {
                Toast.makeText(this, "内容を入力してください。", Toast.LENGTH_SHORT).show()
            }
            binding.addEditText.text.clear()
        }

        //データ削除
        binding.deleteButton.setOnClickListener{
            viewModel.deleteAllData()
        }

        //データを持ってきたら観察して何かをする
        viewModel.getData().observe(this, Observer {
            //TextViewの内容をModelのデータを並べた内容にする
            binding.textView.text = it.map { it.text }.toString()
        })
    }
}