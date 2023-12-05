package com.example.radcooksplash.Models

import com.google.gson.annotations.SerializedName

class Ingredient(
    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,
)
