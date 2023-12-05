package com.example.radcooksplash.webService

import com.example.radcooksplash.Models.Ingredient
import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.Models.Recipe
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.response.IngredientResponse
import com.example.radcooksplash.response.RecipeResponse
import com.example.radcooksplash.response.loginResponse
import com.example.radcooksplash.response.registerResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {
    @POST("user/create/v2")
    fun Registrar(@Body datosRegistro: Register): Call<registerResponse>

    @POST ("login/v2")
    fun Login(@Body datosLogin : Login): Call<loginResponse>

    @POST ("ingredient/create")
    fun Ingredient(@Body datosIngredient : Ingredient): Call<IngredientResponse>

    @POST (" recipe/create")
    fun Recipe(@Body datosRecipe : Recipe): Call<RecipeResponse>


}