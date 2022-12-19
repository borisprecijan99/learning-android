package uns.pmf.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import uns.pmf.learningandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        viewModelFactory = MainActivityViewModelFactory(2022)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        activityMainBinding.btnOpenSecondActivity.setOnClickListener {
            val secondActivityIntent = Intent(this, SecondActivity::class.java)
            startActivity(secondActivityIntent)
        }

        activityMainBinding.btnIncreaseCounter.setOnClickListener {
            viewModel.increaseCounter()
        }

        viewModel.counter.observe(this) { newCounter ->
            activityMainBinding.textViewCounter.text = newCounter.toString()
        }
    }
}