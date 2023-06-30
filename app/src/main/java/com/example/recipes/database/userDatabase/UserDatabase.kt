package com.example.recipes.database.userDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recipes.ListConverters
import com.example.recipes.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(ListConverters::class)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object{
        @Volatile
        private var instance: UserDatabase?= null

        fun getUserDatabaseInstance(context: Context): UserDatabase?{
            if(instance == null)
            {
                synchronized(UserDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance = Room.databaseBuilder(context, UserDatabase::class.java,
                            "user1.db").build()
                    }
                }
            }

            return instance
        }
    }
}

