import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.radcooksplash.R


class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var etResetEmail: EditText
    private lateinit var btnResetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        etResetEmail = findViewById(R.id.etResetEmail)
        btnResetPassword = findViewById(R.id.btnResetPassword)

        btnResetPassword.setOnClickListener {
            val email = etResetEmail.text.toString().trim()

            if (email.isEmpty()) {
                etResetEmail.error = "Ingrese su correo electrónico"
                etResetEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etResetEmail.error = "Ingrese un correo electrónico válido"
                etResetEmail.requestFocus()
                return@setOnClickListener
            }

            // Resto del código...

            Toast.makeText(this, "Se ha enviado un correo de restablecimiento a $email", Toast.LENGTH_SHORT).show()
        }
    }
}
