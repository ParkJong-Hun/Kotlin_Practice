package com.parkjonghun.dialog_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.parkjonghun.dialog_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainViewModel by viewModels()

        //ボタンをクリックしたら
        binding.addButton.setOnClickListener {
            val dialog = MainDialogFragment()
            //作ったDialogFragmentの中のボタンを押したらMainActivityにDialogのEditTextのTextを返す
            dialog.setOnClickListener(object: MainDialogFragment.OnClickListener{
                override fun onClick(inputData: String) {
                    if(inputData.isNotEmpty()) {
                        //返したText使ってViewModelのリストに追加
                        viewModel.addData(inputData)
                    }
                }
            })
            //作ったDialogオブジェクトをsupportFragmentManagerを使って画面に表示する。
            dialog.show(supportFragmentManager, "DialogFragment")
        }

        //ViewModelのリストが変わったら
        viewModel.list.observe(this) {
            //Textにリストの内容全部を代入
            binding.text.text = it.toString()
        }
    }
}