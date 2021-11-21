package teamlab.enginnering.pjh.custom_recycler_view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var view:RecyclerView

    lateinit var simpleAdapter:SimpleAdapter

    val currentDatas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }


    private fun initRecycler() {
        //作ったRecylcerViewをバインド
        view = findViewById(R.id.recyclerView)

        //LayoutManagerに現在のcontextでinit
        val layoutManager = LinearLayoutManager(this)
        //RecyclerViewのLayoutManagerに上に生成したのを適用。
        view.layoutManager = layoutManager

        //CustomAdapterに現在のcontextでinit
        simpleAdapter = SimpleAdapter(this)

        //作ったリスナーインターフェースを使って実装
        simpleAdapter.setOnClickListener(object: SimpleAdapter.OnItemClickListener{
            override fun onItemClick(view: View, data: String, position: Int) {
                //匿名インテント(ClickedActivityにMainActivityのContextを）登録
                Intent(this@MainActivity, ClickedActivity::class.java).apply {
                    //データを送る
                    putExtra("result", currentDatas[position])
                    //新しいTask生成
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { startActivity(this) }//作ったのを実行(実行内容はstartActivity(画面移動))
            }
        })

        //画面に表示するRecylcerViewに使われるAdapterに作ったCustomAdapterを適用。
        view.adapter = simpleAdapter

        //Modelにデータ登録
        currentDatas.apply {
            //Modelにデータ追加
            add("イベント")
            add("お知らせ")
            add("ログアウト")
            add("アカウント")

            //CustomAdapterのModel変数に今追加したModelを代入
            simpleAdapter.datas = currentDatas
            //変わったものがあると伝えてUpdate
            simpleAdapter.notifyDataSetChanged()

            Log.d("変わった", "データが変わりました：${currentDatas}")
        }
    }
}