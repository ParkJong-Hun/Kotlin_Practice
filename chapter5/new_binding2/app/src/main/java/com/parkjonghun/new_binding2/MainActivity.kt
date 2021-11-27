package com.parkjonghun.new_binding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parkjonghun.new_binding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model:TheViewModel = TheViewModel()
        model.userName = "パク"

        binding.vm = model
    }
}