package uns.pmf.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var btnSecondActivity: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnSecondActivity?.setOnClickListener {
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("EXTRA_STRING", "Message from MainActivity")
            startActivity(secondActivityIntent)
        }
    }
}