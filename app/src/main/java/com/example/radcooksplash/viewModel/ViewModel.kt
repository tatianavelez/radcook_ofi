package com.example.radcooksplash.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.telephony.TelephonyManager.UssdResponseCallback
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.response.loginResponse
import com.example.radcooksplash.response.registerResponse
import com.example.radcooksplash.service.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel(application: Application): AndroidViewModel(application) {

    @SuppressLint("SuspiciousIndentation")
    fun registrar(datos:Register, onResponseCallback: (registerResponse?)-> Unit){
        viewModelScope.launch {
        val api = RetrofitClient.webService.Registrar(datos)
            api.enqueue(object: Callback<registerResponse> {
                override fun onResponse(
                    call: Call<registerResponse>,
                    response: Response<registerResponse>
                ) {
                    if(response.isSuccessful){
                        onResponseCallback(response.body())
                    }else{
                        Log.d("error","Respuesta fallida ${response.errorBody()}")
                        onResponseCallback(null)
                    }
                }

                override fun onFailure(call: Call<registerResponse>, t: Throwable) {
                    Log.d("error","Respuesta incorreca ${t.message}")
                    onResponseCallback(null)
                }

            })


        }
    }

    fun login (datos: Login, onResponseCallback: (loginResponse?)-> Unit){
        viewModelScope.launch {
            val call = RetrofitClient.webService.login(datosLogin)
            call.enqueve(object : Callback<loginResponse>{
                override fun onResponse(
                    call: Call <loginResponse>,
                    response: Response<loginResponse>
                ){
                )
        }
    }
}