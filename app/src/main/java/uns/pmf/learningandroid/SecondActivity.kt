package uns.pmf.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnToast = findViewById(R.id.btnToast)
        btnToast.setOnClickListener {
            Toast.makeText(this, "Message!", Toast.LENGTH_SHORT).show()
        }
    }
}