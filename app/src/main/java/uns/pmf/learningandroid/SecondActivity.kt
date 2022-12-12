package uns.pmf.learningandroid

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import uns.pmf.learningandroid.databinding.ActivitySecondBinding
import java.util.*

class SecondActivity : AppCompatActivity() {
    private lateinit var btnRegister: Button
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSelectDate: Button
    private lateinit var activitySecondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)

        btnRegister = activitySecondBinding.btnRegister
        etFirstName = activitySecondBinding.etFirstName
        etLastName = activitySecondBinding.etLastName
        etUsername = activitySecondBinding.etUsername
        etPassword = activitySecondBinding.etPassword
        rgGender = activitySecondBinding.rgGender
        btnSelectDate = activitySecondBinding.btnSelectDate

        btnRegister.setOnClickListener {
            val gender = if (rgGender.checkedRadioButtonId == R.id.rbFemale) "female" else "male"
            val result = "${etFirstName.text}, ${etLastName.text}, ${etUsername.text}, ${etPassword.text}, $gender"
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        btnSelectDate.setOnClickListener {
            val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            val month = Calendar.getInstance().get(Calendar.MONTH)
            val year = Calendar.getInstance().get(Calendar.YEAR)
            val datePickerDialog = DatePickerDialog(this,
                { _, y, m, d -> btnSelectDate.text = "$d.${m + 1}.$y." }, year, month, day)
            datePickerDialog.show()
        }
    }
}