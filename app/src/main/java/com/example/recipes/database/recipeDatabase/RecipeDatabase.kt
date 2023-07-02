package com.example.recipes.database.recipeDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipes.ListConverters
import com.example.recipes.model.Recipe

@Database(entities = [Recipe::class], version = 1)
@TypeConverters(ListConverters::class)
abstract class RecipeDatabase:RoomDatabase() {
    abstract fun RecipeDao():RecipeDao
    companion object{
        @Volatile
        private var instance: RecipeDatabase?= null

        fun getRecipeDatabaseInstance(context: Context): RecipeDatabase?{
            if(instance == null)
            {
                synchronized(RecipeDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance = Room.databaseBuilder(context, RecipeDatabase::class.java,
                            "recipe14.db").allowMainThreadQueries().build()
                    }
                }
            }
            return instance
        }
    }
}
