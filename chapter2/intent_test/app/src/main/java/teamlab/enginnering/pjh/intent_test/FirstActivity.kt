package teamlab.enginnering.pjh.intent_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.math.pow

class FirstActivity : AppCompatActivity() {

    private lateinit var x: EditText
    private lateinit var y: EditText
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        x = findViewById(R.id.x)
        y = findViewById(R.id.y)
        btn = findViewById(R.id.button)
    }

    override fun onStart() {
        super.onStart()

        btn.setOnClickListener{
            val valueX: Float = x.text.toString().toFloat()
            val valueY: Int = y.text.toString().toInt()

            val intent: Intent = Intent(this, SecondActivity::class.java)
            //Log.d("result", "$valueX , $valueY , ${valueX.pow(valueY)}")
            intent.putExtra("result", valueX.pow(valueY).toInt())
            startActivity(intent)
        }
    }
}