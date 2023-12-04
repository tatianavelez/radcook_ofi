package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class RegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var registerButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val imagengif= findViewById<ImageView>(R.id.gifImageView3)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);



        // Obtener referencias a las vistas
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        registerButton = findViewById(R.id.registerButton)

        // Configurar el listener para el botón de registro
        registerButton.setOnClickListener {
            RegisterActivity()
        }
    }

   // private fun registerUser() {
       // val name = etName.text.toString().trim()
       // val email = etEmail.text.toString().trim()
     //   val password = etPassword.text.toString().trim()
      //  val confirmPassword = etConfirmPassword.text.toString().trim()

        // Validar que los campos no estén vacíos
      //  if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
         //   Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
           // return}

        // Validar que las contraseñas coincidan
        //if (password != confirmPassword) {
           // Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
          //  return}
}
