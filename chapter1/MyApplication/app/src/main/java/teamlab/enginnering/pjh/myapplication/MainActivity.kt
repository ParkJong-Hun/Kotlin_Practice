package teamlab.enginnering.pjh.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.TextView)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            if (textView.text.equals("Hello World!")) {
                textView.text = "Hi this is TextView!"
            } else {
                textView.text = "Hello World!"
            }
        }
    }
}