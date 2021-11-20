package teamlab.enginnering.pjh.implicit_intent

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.net.URI
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var imageView:ImageView
    private lateinit var button:Button

    //前の方法から変わった新しいデータ結果物を取り方。
    //グローバル変数じゃないとライフサイクルの状態エラー発生
    // *グローバル変数：전역 변수
    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Uri? = result.data?.data

            //得たイメージをビューに入れ込む
            Glide.with(applicationContext)
                .load(data)
                .into(imageView)

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            selectImage()
        }
    }

    //ギャラリーから写真を選んでビューに表示する
    private fun selectImage() {
        //権限をチェック
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        //権限応答コード
        val REQ_CAMERA_PERMISSION = 1001
        //権限をもらってないのか
        if(permission == PackageManager.PERMISSION_DENIED) {
            //権限更新
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), REQ_CAMERA_PERMISSION)
        } else {
            //ギャラリーからイメージ選ぶ
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), REQ_CAMERA_PERMISSION)
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)

            activityResult.launch(intent)
        }
    }
}