package com.example.recipes.ui.firstScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.recipes.R
import com.example.recipes.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    lateinit var viewModel: FirstScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)
        viewModel = ViewModelProvider(this)[FirstScreenViewModel::class.java]
        binding.lifecycleOwner = this
        binding.getStarted.setOnClickListener {
            viewModel.getStart(this)
        }
    }
}