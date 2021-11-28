package com.parkjonghun.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //gradleにfragment-ktxライブラリーを入れて簡単にViewModelオブジェクトを生成。
        val model: MainViewModel by viewModels()

        //ViewBindingは実装してない状況
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        //ボタンをクリックしたらViewModelのLiveDataの値を変える
        button.setOnClickListener {
            model.text.value = "button clicked"
        }

        //ViewModelのデータが変わったか観察して、変わったらする内容を叙述
        val textObserver = Observer<String> { newText ->
            textView.text = newText
        }

        //LiveDataをObserverと繋げる
        model.text.observe(this, textObserver)
    }
}