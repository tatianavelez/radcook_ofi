package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.databinding.ActivityIngredientBinding
import com.example.radcooksplash.databinding.ActivityRegisterBinding
import com.example.radcooksplash.viewModel.ViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: ViewModel
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //imagengif
        val imagengif = findViewById<ImageView>(R.id.gifImageView3)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);

        //boton
        val button: Button = findViewById(R.id.registerButton)
        button.setOnClickListener {
            CrearRegistro()
        }
    }


    // Obtener referencias a las vistas
    fun CrearRegistro() {

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)

        // Validar que los campos no estén vacíos
        //if(etName.text.toString().isEmpty() || etEmail.text.toString().isEmpty() || etPassword.text.toString().isEmpty() || etConfirmPassword.text.toString().isEmpty()){
            //Validar que las contraseñas coincidan
            if(etPassword.text != etConfirmPassword.text) {
                val DatosRegistro = Register(
                    nombre = etName.text.toString(),
                    correo = etEmail.text.toString(),
                    contraseña = etPassword.text.toString(),
                    Confirmarcontraseña = etConfirmPassword.text.toString(),
                )
                viewModel = ViewModelProvider(this)[ViewModel::class.java]

                viewModel.registrar(DatosRegistro){respuesta ->
                    val res = respuesta?.status.toString()
                    Log.d("Respuesta api", "$res")
                    if(res == "ok"){
                        Toast.makeText(this,"registro exitoso", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"registro fallido", Toast.LENGTH_SHORT).show()

                    }
                }


            }else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }








    }
}

