package teamlab.enginnering.pjh.intent_test

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private var resultValue: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        result = findViewById(R.id.result)
    }

    override fun onStart() {
        super.onStart()

        val intent: Intent = getIntent()
        resultValue = intent.getIntExtra("result", 0)
        result.text = resultValue.toString()
    }
}