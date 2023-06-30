package com.example.recipes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GenerateService {
    private val retrofit: RecipeCall = Retrofit.Builder()
        .baseUrl("https://api.npoint.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RecipeCall::class.java)

    fun getRetrofit(): RecipeCall {
        return retrofit
    }
}