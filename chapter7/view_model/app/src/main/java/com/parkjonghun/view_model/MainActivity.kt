package com.parkjonghun.view_model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.parkjonghun.view_model.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Value Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        //ViewModelオブジェクト生成
        val viewModel: MainViewModel by viewModels()

        //何を観察して、変わったら何をするか
        viewModel.users.observe(this, Observer {
            binding.usersTv.text = viewModel.getUsersToString()
        })

        //ボタンをクリックしたら何をするか
        binding.addUserBtn.setOnClickListener{
            viewModel.setUsers(binding.addUserEt.text.toString())
            binding.addUserEt.setText("")
        }
    }
}