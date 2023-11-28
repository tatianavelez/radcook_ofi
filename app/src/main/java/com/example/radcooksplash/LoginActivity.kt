package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        // Obtener referencias a las vistas
        etLoginEmail = findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)
        loginButton = findViewById(R.id.loginButton)

        val imagengif = findViewById<ImageView>(R.id.gifImageView2)
        Glide.with(this).asGif().load(R.drawable.logingif).into(imagengif)

        // Configurar el listener para el botón de inicio de sesión
        loginButton.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email = etLoginEmail.text.toString().trim()
        val password = etLoginPassword.text.toString().trim()

        // Validar que los campos no estén vacíos
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Iniciar sesión en Firebase
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                    // Aquí puedes agregar lógica adicional después del inicio de sesión exitoso

                    // Ejemplo: Ir a otra actividad (Menulateral en tu caso)
                    val intent = Intent(this, Menulateral::class.java)
                    startActivity(intent)
                    finish() // Cierra la actividad actual
                } else {
                    // Inicio de sesión fallido
                    Toast.makeText(this, "Error en el inicio de sesión: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}