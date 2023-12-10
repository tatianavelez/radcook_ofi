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
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {
    @POST("registro")
    fun Registrar(@Body datosRegistro: Register): Call<registerResponse>

    @POST ("login")
    fun Login(@Body datosLogin : Login): Call<loginResponse>

    @POST ("ingredient")
    fun Ingredient(@Body datosIngredient : Ingredient): Call<IngredientResponse>

    @POST ("recipe/create")
    fun RecipeCreate(@Body datosRecipe : Recipe): Call<RecipeResponse>

    @GET("ingredients")
    fun getIngredient(): Call<List<Ingredient>>



}