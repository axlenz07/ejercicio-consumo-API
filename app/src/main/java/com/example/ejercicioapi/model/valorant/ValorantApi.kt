package com.example.ejercicioapi.model.valorant

import retrofit2.Response
import retrofit2.http.GET

interface ValorantApi {

    @GET("agents")
    suspend fun getAllAgents(): Response<Valorant>
}