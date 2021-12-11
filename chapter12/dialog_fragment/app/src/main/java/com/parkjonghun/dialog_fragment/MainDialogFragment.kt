package com.parkjonghun.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.parkjonghun.dialog_fragment.databinding.DialogMainBinding

class MainDialogFragment: DialogFragment() {
    private var _binding: DialogMainBinding? = null
    private val binding get() = _binding!!

    //DialogのViewの初期化（最初すること）
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogMainBinding.inflate(inflater, container, false)
        val view = binding.root
        //ボタンをクリックしたら
        binding.button.setOnClickListener{
            //オブジェクトの親でこの関数にEditTextのTextを引数として実装して呼び出す
            onClickListener.onClick(binding.editText.text.toString())
            //Dialogを消す
            dismiss()
        }
        //メソッドで初期化の結果物のViewを返す
        return view
    }
    //DialogのViewがなくなったら（最後すること）
    override fun onDestroyView() {
        super.onDestroyView()
        //BindingオブジェクトをNullに
        _binding = null
    }



    //カスタムリスナーを実装

    //Callback関数のリスナーオブジェクト
    private lateinit var onClickListener: OnClickListener
    //親オブジェクトから実装する関数を作るためのインターフェース
    interface OnClickListener {
        fun onClick(inputData: String)
    }
    //リスナーを持ってほかのところで呼び出すためにDialogにメソッドを作る
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
}