package com.parkjonghun.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.parkjonghun.sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadData()

        binding.addButton.setOnClickListener{
            viewModel.setData(binding.addEditText.text.toString())
            binding.addEditText.text.clear()
        }

        binding.deleteButton.setOnClickListener{
            viewModel.deleteAllData()
        }

        viewModel.data.observe(this, Observer {
            binding.textView.text = viewModel.getData()
        })
    }
}