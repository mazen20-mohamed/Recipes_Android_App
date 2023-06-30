package com.example.recipes.database.userDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipes.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("select * From user WHERE :e==email AND :p==password")
    fun getUser(e:String?,p: String?):List<User>

    @Query("select * From user WHERE :e==email")
    fun getUser(e:String?):List<User>
}