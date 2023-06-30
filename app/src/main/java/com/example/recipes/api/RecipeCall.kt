package com.example.recipes.api

import com.example.recipes.model.Recipe
import retrofit2.Call
import retrofit2.http.GET

interface RecipeCall {

    @GET("43427003d33f1f6b51cc")
    fun getRecipes(): Call<List<Recipe>>?
}