package com.example.recipes.ui.listRecipe

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recipes.api.GenerateService
import com.example.recipes.model.Recipe
import com.example.recipes.model.User
import com.example.recipes.repo.RecipeRepo
import com.example.recipes.repo.UserRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecipeViewModel: ViewModel() {

    fun addRecipeToDatabase(context: Context){
        GenerateService.getRetrofit().getRecipes()?.enqueue(object:Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                val res = response.body()
                if (res != null) {
                    for(i in res){

                        RecipeRepo.addRecipe(context,i)
                    }
                }
            }
            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {

            }
        })
    }

    fun getRecipes(context: Context): LiveData<List<Recipe>>?{
        return RecipeRepo.getRecipes(context)
    }

    fun getFavourites(context: Context,email:String): MutableList<User>? {
        return UserRepo.getUserList(context,email)
    }
}

