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
        fun getUserList(context:Context, email:String, password:String): List<User>?
        {
                userDatabase = initialiseDB(context)
                return userDatabase?.userDao()?.getUser(email, password)
        }

        fun getUserList(context: Context, email: String): MutableList<User>? {
            userDatabase = initialiseDB(context)
            return userDatabase?.userDao()?.getUser(email)
        }
        fun getFavorite(context: Context,email: String):MutableList<String>?{
            userDatabase = initialiseDB(context)
            return userDatabase?.userDao()?.getFavorite(email)
        }
        fun updateUser(context: Context,favourite: MutableList<String>,email: String){
            userDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                userDatabase?.userDao()?.updateUser(favourite,email)
            }
        }
    }

}