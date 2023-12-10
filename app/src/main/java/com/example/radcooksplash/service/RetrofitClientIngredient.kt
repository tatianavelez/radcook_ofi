package com.example.radcooksplash.service

import com.example.radcooksplash.webService.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientIngredient {
    private const val BASE_URL = "https://apis-intento4-production.up.railway.app/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val Service:  Service by lazy {
        retrofit.create( Service::class.java)
    }
}