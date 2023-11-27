package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class LoginActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val imagengif= findViewById<ImageView>(R.id.gifImageView2)

        Glide.with(this).asGif().load(R.drawable.logingif).into(imagengif);

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
          val intent = Intent(this, Menulateral::class.java)
            startActivity(intent)
        }
    }
}