package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val imagengif= findViewById<ImageView>(R.id.gifImageView3)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);

        val registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
          val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}
