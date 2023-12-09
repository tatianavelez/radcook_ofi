package com.example.radcooksplash.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.telephony.TelephonyManager.UssdResponseCallback
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.radcooksplash.Models.Ingredient
import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.response.IngredientResponse
import com.example.radcooksplash.response.loginResponse
import com.example.radcooksplash.response.registerResponse
import com.example.radcooksplash.service.RetrofitClient
import com.example.radcooksplash.service.RetrofitClient.webService
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
            val call = RetrofitClient.webService.Login(datos)
            call.enqueue(object : Callback<loginResponse>{
                override fun onResponse(
                    call: Call <loginResponse>,
                    response: Response<loginResponse>
                ){
                    if(response.isSuccessful){
                        onResponseCallback(response.body())
                    }else{
                        onResponseCallback(null)
                    }

                }

                override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                    onResponseCallback(null)
                }
            }
                )
        }
    }

    fun CreateIngredient (datos: Ingredient, onResponseCallback: (IngredientResponse?)-> Unit){
        viewModelScope.launch {
            val api = RetrofitClient.webService.Ingredient(datos)
            api.enqueue(object: Callback<IngredientResponse> {
                override fun onResponse(
                    call: Call<IngredientResponse>,
                    response: Response<IngredientResponse>
                ) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<IngredientResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
        }

    }


    private var _Ingredient = MutableLiveData<List<Ingredient>>()
    val Ingredient: LiveData<List<Ingredient>> get()= _Ingredient

    fun loadIngredients() {
        webService.getIngredient().enqueue(object : Callback<List<Ingredient>> {
            override fun onResponse(call: Call<List<Ingredient>>, response: Response<List<Ingredient>>) {
                if (response.isSuccessful) {
                    _Ingredient.value = response.body()
                } else {
                    Log.d("error","${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Ingredient>>, t: Throwable) {
                // Manejar errores de red
            }
        })
    }

}