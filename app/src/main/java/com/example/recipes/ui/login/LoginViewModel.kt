package com.example.recipes.ui.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.repo.UserRepo
import com.example.recipes.model.User
import com.example.recipes.ui.listRecipe.MainScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel(){

    // check if email and password entries correctly
    fun checkLogin(context: Context,email:String , password:String)= viewModelScope.launch(Dispatchers.IO) {
        if(UserRepo.getUser(context,email,password)?.isNotEmpty() == true){
            val intent = Intent(context, MainScreen::class.java)
            context.startActivity(intent)
        }
        else{
            Toast.makeText(context,"password or email is not correct",Toast.LENGTH_SHORT).show()
        }
    }

    // add email and password to test app
    fun addUserToDatabase(context: Context)
    {
        UserRepo.addUSer(context,User(email = "eldessoukymazen16@gmail.com", password = "1234", favourites = listOf()))
    }
}
