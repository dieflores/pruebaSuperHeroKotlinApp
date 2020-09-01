package com.example.superheroprueba

import com.example.superheroprueba.pojo.SuperHero
import retrofit2.Call
import retrofit2.http.*


interface ApiSuperHero{
    @GET("")
    fun getAllSuperHero(): Call<List<SuperHero>>

    @DELETE("")
    fun deleteSuperHero(@Path("") heroId: Int?): Call<Void>

    @POST("")
    fun createNewHero(@Body superHero: SuperHero): Call<SuperHero>
}