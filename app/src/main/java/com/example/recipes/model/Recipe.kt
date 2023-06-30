package com.example.recipes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("database_id") val databaseId:Int,
    @SerializedName("id"                        ) var id                       : String?           = null,
    @SerializedName("fats"                      ) var fats                     : String?           = null,
    @SerializedName("name"                      ) var name                     : String?           = null,
    @SerializedName("time"                      ) var time                     : String?           = null,
    @SerializedName("image"                     ) var image                    : String?           = null,
    @SerializedName("weeks"                     ) var weeks                    : List<String> = listOf(),
    @SerializedName("carbos"                    ) var carbos                   : String?           = null,
    @SerializedName("fibers"                    ) var fibers                   : String?           = null,
    @SerializedName("rating"                    ) var rating                   : String?           = null,
    @SerializedName("country"                   ) var country                  : String?           = null,
    @SerializedName("ratings"                   ) var ratings                  : String?           = null,
    @SerializedName("calories"                  ) var calories                 : String?           = null,
    @SerializedName("headline"                  ) var headline                 : String?           = null,
    @SerializedName("keywords"                  ) var keywords                 : List<String> = listOf(),
    @SerializedName("products"                  ) var products                 : List<String> = listOf(),
    @SerializedName("proteins"                  ) var proteins                 : String?           = null,
    @SerializedName("favorites"                 ) var favorites                : Int?              = null,
    @SerializedName("difficulty"                ) var difficulty               : Int?              = null,
    @SerializedName("description"               ) var description              : String?           = null,
    @SerializedName("highlighted"               ) var highlighted              : Boolean?          = null,
    @SerializedName("ingredients"               ) var ingredients              : List<String> = listOf(),
    @SerializedName("incompatibilities"         ) var incompatibilities        : String?           = null,
    @SerializedName("deliverable_ingredients"   ) var deliverableIngredients   : List<String> = listOf(),
    @SerializedName("undeliverable_ingredients" ) var undeliverableIngredients : List<String> = listOf()

)