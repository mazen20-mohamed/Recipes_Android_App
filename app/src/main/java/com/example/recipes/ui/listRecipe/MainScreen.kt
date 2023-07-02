package com.example.recipes.ui.listRecipe
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.Listener
import com.example.recipes.R
import com.example.recipes.databinding.ActivityMainScreenBinding
import com.example.recipes.model.Recipe
import com.example.recipes.ui.login.LoginActivity
import com.example.recipes.ui.login.LoginViewModel
import com.example.recipes.ui.recipeDetail.RecipeDetailActivity

class MainScreen : AppCompatActivity(), Listener {
    lateinit var binding: ActivityMainScreenBinding
    lateinit var recyclerView: RecyclerView
    lateinit var recipeAdapter: RecipeAdapter
    lateinit var recipeViewModel: RecipeViewModel
    lateinit var recipeList:ArrayList<Recipe>
    lateinit var email:String
    lateinit var sharedPreference:SharedPreferences
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_screen)

        recipeViewModel = ViewModelProvider(this)[RecipeViewModel::class.java]
        binding.lifecycleOwner = this


        sharedPreference =  getSharedPreferences("userEmail", Context.MODE_PRIVATE)
        email = sharedPreference.getString("email","eldessoukymazen16@gmail.com").toString()

        initializeRecyclerView()

        // add recipes to database
        recipeViewModel.addRecipeToDatabase(this)

        recipeViewModel.getRecipes(this)?.observe(this, Observer {
            recipeAdapter.recipeList = it as ArrayList<Recipe>
            recipeAdapter.notifyDataSetChanged()
            recipeList = it
        })

    }

    fun initializeRecyclerView(){
        recyclerView = binding.rvRecipe
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = layoutManager

        val user = recipeViewModel.getFavourites(this,email)
        recipeAdapter = RecipeAdapter(ArrayList<Recipe>(),user?.get(0)?.favourites ,this)
        recyclerView.adapter = recipeAdapter

    }

    override fun onClickListener(position: Int) {
        val intent= Intent(this, RecipeDetailActivity::class.java)
        intent.putExtra("recipe",recipeList[position])
        startActivity(intent)
        recipeAdapter.favourite = recipeViewModel.getFavourites(this,email)?.get(0)?.favourites
        recipeAdapter.notifyDataSetChanged()
    }
}
