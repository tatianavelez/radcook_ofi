package com.example.radcooksplash.webService

import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.response.registerResponse
import retrofit2.Call
import retrofit2.http.POST

interface Service {
    @POST("user/create/v2")
    fun Registrar(datosRegistro: Register): Call<registerResponse>
}