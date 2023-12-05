package com.example.radcooksplash.webService

import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.Models.Register
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
}