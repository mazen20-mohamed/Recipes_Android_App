package com.example.recipes.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.recipes.R
import com.example.recipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this

//        // add user to database to login by it
        loginViewModel.addUserToDatabase(this)


         //check user if click btn login
        binding.login.setOnClickListener {
            loginViewModel.checkLogin(this,binding.email1.text.toString(),binding.password1.text.toString())
        }

    }
}