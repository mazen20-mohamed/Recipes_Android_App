package com.example.recipes.ui.recipeDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipes.model.Recipe
import com.example.recipes.repo.UserRepo

class RecipeDetailViewModel: ViewModel() {

    var recipe:MutableLiveData<Recipe> = MutableLiveData()

    fun loadData(intent: Intent){
        val bundle:Bundle?=intent.extras

        if(bundle != null){
            val recipee = bundle.getSerializable("recipe") as Recipe
            recipe.value = recipee
        }
    }


    fun getFavourite(context: Context, email:String): MutableList<String>? {
        return UserRepo.getFavorite(context,email)
    }
}