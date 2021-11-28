package com.parkjonghun.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//ビューモデルはMVVMで使ってる単位で、Modelからデータを持ってきてビューに最適な方に加工するモデル。
//ビューはビューモデルにどんなイベントが起こったのか教える。
//ビューモデルは基本的なモデルとビュー間のデータ処理を担当。
//モデル（リポジトリ、地域データ、遠隔データ）はビューモデルの請けに必要なデータを返す。
//ビューモデルは自分を観察してるビューにモデルからもらったデータを加工して結果物として応答（Callback)を返す。
//つまりビューは何が起こったのかビューモデルにただ通知すればいい。
//基本何か変えたりするのはビューモデルがする。
//観察ーデータ加工ーデータを持ってくるがこれの重要ポイント

class MainViewModel: ViewModel() {
    //observeはLiveDataオブジェクトをObserveオブジェクトにアタッチする。
    //LiveCycleOwnerを取得する。
    val text: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}