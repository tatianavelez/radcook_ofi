package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class EnterRecipe : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_recipe)

        //imagen gif para tener movimiento
        val imagengif= findViewById<ImageView>(R.id.gifImageView4)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);


        val autoCompleteRecipe = findViewById<AutoCompleteTextView>(R.id.autoCompleteRecipe)
        val editTextCantidad = findViewById<EditText>(R.id.createIngredientes)
        val btnAgregarIngrediente = findViewById<Button>(R.id.crearButton)

        // tipo de recetas
        val items = listOf(
            "Panadería", "Postres",
            "Salsas", "Bebidas",
            "Ensaladas", "Platos principales",
            "Bocadillos", "Sopas",
            "Acompañamientos",
            "Comida rápidas")

        val autoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteRecipe)
        val adapter = ArrayAdapter(this, R.layout.items_pqrs, items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener{ adapterView, view, i, l ->
                val tipoSelect = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "$tipoSelect", Toast.LENGTH_SHORT).show()
            }
    }
}
