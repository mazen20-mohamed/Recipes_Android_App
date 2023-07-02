package com.example.recipes.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.recipes.R
import com.example.recipes.databinding.ActivityLoginBinding
import com.example.recipes.repo.UserRepo

class LoginActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.lifecycleOwner = this

//      add user to database to login by it , just one time enough
        loginViewModel.addUserToDatabase(this)

//        val user = UserRepo.getUser(this,"eldessoukymazen16gmail.com","1234")
//        if(user == null){
//            Log.d("#####","انا زهقت")
//        }

         //check user if click btn login
        binding.login.setOnClickListener {
            val sharedPreference =  getSharedPreferences("userEmail", Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()
            editor.putString("email",binding.email1.text.toString())
            editor.commit()
            loginViewModel.checkLogin(this,binding.email1.text.toString(),binding.password1.text.toString())
        }
    }
}
