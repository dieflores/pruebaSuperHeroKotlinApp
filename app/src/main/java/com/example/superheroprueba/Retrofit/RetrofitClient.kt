package com.example.superheroprueba.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"
        fun retrofitInstance(): ApiSuperHero {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiSuperHero::class.java)
        }
    }
}