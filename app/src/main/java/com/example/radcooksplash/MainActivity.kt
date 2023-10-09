package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clothingCard = findViewById<CardView>(R.id.clothingCard)
        clothingCard.setOnClickListener {
            val intent = Intent(this@MainActivity, search::class.java)
            startActivity(intent)
        }
    }
}