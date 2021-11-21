package teamlab.enginnering.pjh.custom_recycler_view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ClickedActivity: AppCompatActivity() {

    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_is_clicked)

        result = findViewById(R.id.result)

        val intent = getIntent()
        result.text = intent.getStringExtra("result")
    }
}