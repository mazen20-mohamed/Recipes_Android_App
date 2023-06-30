package com.example.recipes.database.recipeDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipes.model.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    @Query("select * from Recipe")
    fun getRecipes():LiveData<List<Recipe>>

    @Query("select * from Recipe where :id==id")
    fun getRecipe(id:String?):LiveData<Recipe>
}