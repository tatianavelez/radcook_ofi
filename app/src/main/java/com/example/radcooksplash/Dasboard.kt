package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class Dasboard : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasboard)

        //search
        val searchCard = findViewById<CardView>(R.id.searchCard)
        searchCard.setOnClickListener()
        {
            val intent = Intent(this@Dasboard, search::class.java)
            startActivity(intent)
        }

        //foro
        val forumCard = findViewById<CardView>(R.id.forumCard)
        forumCard.setOnClickListener()
        {
            val intent = Intent(this@Dasboard, Forum::class.java)
            startActivity(intent)
        }

        //ingresar receta
        val enterrecipeCard = findViewById<CardView>(R.id.enterrecipeCard)
        enterrecipeCard.setOnClickListener()
        {
            val intent = Intent(this@Dasboard, EnterRecipe::class.java)
            startActivity(intent)
        }

        //ingresar ingrediente

        val enteringredientCard = findViewById<CardView>(R.id.enteringredientCard)
        enteringredientCard.setOnClickListener()
        {
            val intent = Intent(this@Dasboard, Ingredient::class.java)
            startActivity(intent)
        }

        //favoritos
        val favoriteCard = findViewById<CardView>(R.id.favoritetCard)
        favoriteCard.setOnClickListener()
        {
            val intent = Intent(this@Dasboard, Favorite::class.java)
            startActivity(intent)
        }


    }
}