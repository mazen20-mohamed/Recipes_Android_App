package com.example.recipes.database.userDatabase

import androidx.room.*
import com.example.recipes.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("select * From user WHERE :e==email AND :p==password")
    fun getUser(e:String?,p: String?):List<User>

    @Query("select * From user WHERE :e==email")
    fun getUser(e:String?):MutableList<User>

    @Query("select recipe_id From user WHERE :e==email")
    fun getFavorite(e:String?):MutableList<String>


    @Query("UPDATE user SET recipe_id =:favorite WHERE :e==email")
    suspend fun updateUser(favorite:MutableList<String>,e:String)
}