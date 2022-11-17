package uns.pmf.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvText: TextView
    private lateinit var btnClickMe: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        btnClickMe = findViewById(R.id.btnClick)

        btnClickMe.setOnClickListener {
            tvText.text = "Button is clicked"
        }
    }
}