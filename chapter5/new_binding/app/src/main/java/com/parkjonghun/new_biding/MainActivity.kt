package com.parkjonghun.new_biding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parkjonghun.new_biding.databinding.ActivityMainBinding

//ViewBinding機能を使ったらビューとインタラクティブなコードを簡単に作成できる。
//モジュールから使用設定できたViewBindingはモジュールにある各XML Layout FileのBinding Classを生成する。
//Binding Classのインスタンスには応じるLayoutでIDがある全てのビューの直接参考が含まれてる。

//**大部分の場合、ViewBindingはもとの「findViewById」を置き換える。（アンドロイド3.6Canary11から使える）

//使う前に一旦build.gradleにviewBinding要素を書く。

class MainActivity : AppCompatActivity() {

    //一般的なActivityのValueBindingの方法
    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)//定義した変数Activityの内容を持ってくる。
        val view = binding.root//BindingClassからRootビューをゲット。（つまりLinearLayoutをゲット）

        //setContentView(R.layout.activity_main)//もともと使った方法
        setContentView(view)//同じ結果
            //binding.textView.text = viewModel.textView　ViewModelで値をもってきて代入
            binding.button.setOnClickListener{ /*ViewModelでクリックしたらすることを作成。*/ }
    }

    /*
    Fragmentではnullを判断してBindingをする。
    フィールドにBindingClassインスタンスを定義
    private var _binding: ActivityMainBinding? = null

    フィールドにBindingClassインスタンスを定義
    private lateinit var binding get() = _binding!!*/

    /*FrgmentのValueBindingの方法
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    //Frgmentの生涯の最後
    override fun onDestroy() {
        super.onDestroy()
        _binding = null//_binding変数を空にする
    }
     */
}