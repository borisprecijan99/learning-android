package uns.pmf.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvText: TextView
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        tvText.setOnClickListener {
            Log.d(tag, "TextView is clicked!")
        }

        Log.d(tag, "onCreate is called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume is called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy is called")
    }
}