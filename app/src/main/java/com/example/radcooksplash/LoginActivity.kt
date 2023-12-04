package com.example.radcooksplash

import ResetPasswordActivity
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class LoginActivity : AppCompatActivity() {
    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var loginButton: Button


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // Obtener referencias a las vistas
        etLoginEmail = findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)
        loginButton = findViewById(R.id.loginButton)

        val imagengif = findViewById<ImageView>(R.id.gifImageView2)
        Glide.with(this).asGif().load(R.drawable.logingif).into(imagengif)

        fun forgotPasswordClicked(view: View) {
            // Aquí se inicia una nueva actividad para restablecer la contraseña
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        // Configurar el listener para el botón de inicio de sesión
        loginButton.setOnClickListener {
            HomeFragment()
        }
    }

    //private fun loginUser() {
       // val email = etLoginEmail.text.toString().trim()
       // val password = etLoginPassword.text.toString().trim()

        // Validar que los campos no estén vacíos
       // if (email.isEmpty() || password.isEmpty()) {
           // Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
           // return
       // }


  //  }
}