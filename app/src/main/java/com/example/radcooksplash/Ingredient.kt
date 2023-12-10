package com.example.radcooksplash

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

class Ingredient : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient)

        //imagen gif para tener movimiento
        val imagengif= findViewById<ImageView>(R.id.gifImageView1)
        Glide.with(this).asGif().load(R.drawable.agucate).into(imagengif);

        val autoCompleteRecipe = findViewById<AutoCompleteTextView>(R.id.autoCompleteIngredient)
        val editTextIngrediente = findViewById<EditText>(R.id.nameIngredient)
        val btnCrearIngrediente = findViewById<Button>(R.id.crearIngrediente)

        // tipo de recetas
        val items = listOf(
            "Fruta","Verdura", "Carne","Pescado" ,
            "Lácteos","Cereales" , "Legumbres", "Hierbas y Especias",
            "Aceites y Grasas", "Frutos Secos", "Mariscos","Huevos",
            "Salsas","Bebidas", "Postres","Pan y Panadería",
            "Dulces","Condimentos", "Café y Té","Congelados")

        val autoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteIngredient)
        val adapter = ArrayAdapter(this, R.layout.items_pqrs, items)
        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener{ adapterView, view, i, l ->
                val tipoSelect = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "$tipoSelect", Toast.LENGTH_SHORT).show()
            }
    }
}