package uns.pmf.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uns.pmf.learningandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.counter = 0

        activityMainBinding.downloadDataButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }

        activityMainBinding.increaseCounterButton.setOnClickListener {
            activityMainBinding.counter = activityMainBinding.counter?.plus(1)
        }
    }

    private suspend fun downloadData() {
        for (i in 1..100000) {
            withContext(Dispatchers.Main) {
                activityMainBinding.textViewMessage.text =
                    "Downloading user $i in ${Thread.currentThread().name}."
            }
        }
    }
}