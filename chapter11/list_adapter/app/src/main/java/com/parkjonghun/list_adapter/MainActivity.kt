package com.parkjonghun.list_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.parkjonghun.list_adapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainViewModel by viewModels()

        val recyclerView = binding.RecyclerView
        val adapter = MainAdapter()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        viewModel.data.observe(this) {
            recyclerView.adapter = adapter
            adapter.submitList(it)//DiffUtilを使ったAdapter違ってListAdapterは直接submitListができる。
        }

        binding.Button.setOnClickListener {
            viewModel.addDataOnList(binding.EditText.text.toString())
            binding.EditText.text.clear()
        }
    }
}