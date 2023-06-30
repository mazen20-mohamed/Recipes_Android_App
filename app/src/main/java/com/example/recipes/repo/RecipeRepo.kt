package com.example.recipes.repo

import android.content.Context
import com.example.recipes.database.recipeDatabase.RecipeDatabase
import com.example.recipes.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeRepo {
    companion object
    {
        private var recipeDatabase: RecipeDatabase?=null
        private fun initialiseDB(context: Context): RecipeDatabase?
        {
            return  RecipeDatabase.getRecipeDatabaseInstance(context)
        }

        fun addRecipe(context: Context, recipe: Recipe){
            recipeDatabase = initialiseDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                recipeDatabase?.RecipeDao()?.insertRecipe(recipe)
            }
        }


    }
}