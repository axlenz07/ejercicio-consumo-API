package com.example.ejercicioapi.model.digimon

import retrofit2.Response
import retrofit2.http.GET

interface DigimonApi {

    @GET("api/digimon")
    suspend fun getAllDigimon(): Response<List<Digimon>>
}