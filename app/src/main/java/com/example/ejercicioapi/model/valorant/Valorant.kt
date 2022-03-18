package com.example.ejercicioapi.model.valorant

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Valorant(
    @SerializedName("status") var status: Int,
    @SerializedName("data") var datos: List<Agents>
)

data class Agents(
    @SerializedName("uuid") var uniqueId: String,
    @SerializedName("displayName") var nombre: String,
    @SerializedName("description") var info: String,
    @SerializedName("displayIcon") var image: String,
    @SerializedName("bustPortrait") var full: String,
    @SerializedName("background") var fondo: String,
    @SerializedName("role") var rol: Role,
    @SerializedName("abilities") var abilities: List<Abilities>
) : Serializable

data class Role(
    @SerializedName("displayName") var rolTexto: String,
    @SerializedName("description") var rolDesc: String,
    @SerializedName("displayIcon") var rolIcon: String
) : Serializable

data class Abilities(
    @SerializedName("displayName") var nameAbilitie: String,
    @SerializedName("description") var descAbilitie: String,
    @SerializedName("displayIcon") var iconAbilitie: String
) : Serializable