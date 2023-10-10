package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchCard = findViewById<CardView>(R.id.searchCard)
        searchCard.setOnClickListener {
            val intent = Intent(this@MainActivity, search::class.java)
            startActivity(intent)
        }
    }
}