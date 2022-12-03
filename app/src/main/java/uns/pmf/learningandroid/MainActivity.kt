package uns.pmf.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uns.pmf.learningandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnOpenSecondActivity.setOnClickListener {
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("EXTRA_STRING", "Message from MainActivity")
            startActivity(secondActivityIntent)
        }
    }
}