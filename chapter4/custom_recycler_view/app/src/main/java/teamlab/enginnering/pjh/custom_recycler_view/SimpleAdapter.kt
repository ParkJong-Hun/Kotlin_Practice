package teamlab.enginnering.pjh.custom_recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(private val context: Context): RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    //Model
    var datas = mutableListOf<String>()
    //Listener
    private var listener: OnItemClickListener? = null

    //ViewHolderが生成された時
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleAdapter.ViewHolder {
        //LayoutInflaterにcontextをもとにして該当するLayoutをInflate
        //要素はResource, ViewGroup, attachToRoot
        val view = LayoutInflater.from(context).inflate(R.layout.item_of_recycler_view, parent,false)
        //インフレーターしたLayoutInflaterを返す
        return ViewHolder(view)
    }

    //各アイテムにデザインしたビューをバインド
    override fun onBindViewHolder(holder: SimpleAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    //アイテムを総じて何個表現するか
    override fun getItemCount(): Int {
        return datas.size
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    //ViewHolder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.item_title)
        //実装したビューをバインドするための関数
        fun bind(item: String) {
            title.text = item

            //現在の位置を返す
            val position = adapterPosition
            //位置がないんじゃないと(アイテムが０個じゃないと)
            if(position != RecyclerView.NO_POSITION) {
                //今の位置のアイテムビューにリスナーを設定
                itemView.setOnClickListener{
                    //onItemClickを実行
                    listener?.onItemClick(itemView, item, position)
                }
            }
        }
    }

    //アイテムをクリックした時のリスナーのインターフェース宣言
    interface OnItemClickListener {
        fun onItemClick(view: View, data: String, position: Int)
    }
}