package com.example.ejercicioapi.model.digimon

import com.google.gson.annotations.SerializedName

data class Digimon(
    @SerializedName("name") var nombre: String,
    @SerializedName("img") var imagen: String,
    @SerializedName("level") var nivel: String
)
