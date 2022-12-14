package uns.pmf.learningandroid

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import uns.pmf.learningandroid.databinding.ActivitySecondBinding
import java.util.*

class SecondActivity : AppCompatActivity() {
    private lateinit var activitySecondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        val user: User = User("Boris", "Precijan", "risbo99", "risbo99", "16.11.1999.", true)
        activitySecondBinding.user = user

        activitySecondBinding.btnRegister.setOnClickListener {
            Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()
        }

        activitySecondBinding.btnSelectDate.setOnClickListener {
            val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            val month = Calendar.getInstance().get(Calendar.MONTH)
            val year = Calendar.getInstance().get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(this,
                { _, y, m, d ->
                    val selectedDate = "$d.${m + 1}.$y."
                    activitySecondBinding.btnSelectDate.text = selectedDate
                    user.dateOfBirth = selectedDate
                }, year, month, day)
            datePickerDialog.show()
        }
    }
}