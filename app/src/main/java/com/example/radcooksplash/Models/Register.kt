package com.example.radcooksplash.Models
import com.google.gson.annotations.SerializedName;
class Register
    (
    @SerializedName("name")
    var nombre: String,

    @SerializedName("email")
    var correo: String,

    @SerializedName("password")
    var contraseña: String,

    @SerializedName("password_confirmation")
    var Confirmarcontraseña: String,
)
