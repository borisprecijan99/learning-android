package uns.pmf.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var btnRegister: Button
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var rgGender: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnRegister = findViewById(R.id.btnRegister)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        rgGender = findViewById(R.id.rgGender)

        btnRegister.setOnClickListener {
            val gender = if (rgGender.checkedRadioButtonId == R.id.rbFemale) "female" else "male"
            val result = "${etFirstName.text}, ${etLastName.text}, ${etUsername.text}, ${etPassword.text}, $gender"
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }
}