package com.example.recipes.repo

import android.content.Context
import com.example.recipes.database.userDatabase.UserDatabase
import com.example.recipes.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepo {
    companion object
    {
        private var userDatabase: UserDatabase?=null
        private fun initialiseDB(context: Context): UserDatabase?
        {
            return  UserDatabase.getUserDatabaseInstance(context)
        }
        fun addUSer(context:Context,user: User){
            userDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                userDatabase?.userDao()?.insertUser(user = user)
            }
        }
        fun getUser(context:Context,email:String, password:String): List<User>?
        {
                userDatabase = initialiseDB(context)
                return userDatabase?.userDao()?.getUser(email, password)
        }

    }


}