package com.example.recipes.ui.recipeDetail

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipes.R
import com.example.recipes.databinding.ActivityRecipeDetailBinding
import com.example.recipes.repo.UserRepo

class RecipeDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecipeDetailBinding
    lateinit var recipeDetailViewModel: RecipeDetailViewModel
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_recipe_detail)
        recipeDetailViewModel = ViewModelProvider(this)[RecipeDetailViewModel::class.java]
        binding.lifecycleOwner = this

        recipeDetailViewModel.loadData(intent)
        val sharedPreference =  getSharedPreferences("userEmail", Context.MODE_PRIVATE)
        val email = sharedPreference.getString("email","eldessoukymazen16@gmail.com").toString()
        var user =recipeDetailViewModel.getFavourite(this,email)

        recipeDetailViewModel.recipe.observe(this , Observer {
            Glide.with(this)
                .load(it.image)
                .into(binding.imgDetail)
            binding.recipeNameDetail.text = it.name.toString()
            binding.kcal.text = it.calories
            binding.mins.text = it.time?.substring(2,4)+" min"
            binding.ingredientDetail.text = it.ingredients.toString()
            if (user != null) {
                for(i in user!!){
                    if(i == recipeDetailViewModel.recipe.value?.id.toString()){
                        binding.favouritee.setImageResource(R.drawable.favourite)
                    }
                    else{
                        binding.favouritee.setImageResource(R.drawable.unfavourite)
                    }
                }
            }
        })

        binding.favouritee.setOnClickListener {
            user =recipeDetailViewModel.getFavourite(this,email)
            if(user?.contains(recipeDetailViewModel.recipe.value?.id.toString())==true){
                binding.favouritee.setImageResource(R.drawable.unfavourite_64)
            }
            else{
                binding.favouritee.setImageResource(R.drawable.favourite_64)
                if(user != null){
                    user!!.add(recipeDetailViewModel.recipe.value?.id.toString())
                    UserRepo.updateUser(this, user!!,email)
                }
            }
        }
    }
}
