package com.example.recipes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "email")val email:String,
    @ColumnInfo(name = "password")val password:String?,
    @ColumnInfo(name = "recipe_id")val favourites:MutableList<String> = mutableListOf<String>()
)
