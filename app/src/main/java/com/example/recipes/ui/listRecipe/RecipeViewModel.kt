package com.example.recipes.ui.listRecipe

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.recipes.api.GenerateService
import com.example.recipes.model.Recipe
import com.example.recipes.repo.RecipeRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecipeViewModel: ViewModel() {

    fun addRecipeToDatabase(context: Context,recipe: Recipe){
        GenerateService.getRetrofit().getRecipes()?.enqueue(object:Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                val res = response.body()
                if (res != null) {
                    for(i in res){
                        RecipeRepo.addRecipe(context,recipe)
                    }
                }
            }
            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {

            }
        })
    }

}

