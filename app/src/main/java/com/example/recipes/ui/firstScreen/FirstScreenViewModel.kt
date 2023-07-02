package com.example.recipes.ui.firstScreen

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.recipes.ui.login.LoginActivity

class FirstScreenViewModel:ViewModel() {
    fun getStart(context:Context){
        context.startActivity(Intent(context,LoginActivity::class.java))
    }
}