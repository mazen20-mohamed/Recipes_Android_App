package com.example.recipes.ui.listRecipe

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipes.Listener
import com.example.recipes.R
import com.example.recipes.model.Recipe

class RecipeAdapter(var recipeList:ArrayList<Recipe>,var favourite:MutableList<String>?,private val listener: Listener): RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>()  {

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val image = itemView.findViewById<ImageView>(R.id.img)
        val name = itemView.findViewById<TextView>(R.id.recipe_name)
        val time = itemView.findViewById<TextView>(R.id.time_make)
        val calory = itemView.findViewById<TextView>(R.id.calory)
        val favourite = itemView.findViewById<ImageView>(R.id.favourite)
        init {
            itemView.setOnClickListener {
                listener.onClickListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recipe_card,parent,false))
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }


    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe =recipeList[position]
        holder.name.text = recipe.name
        holder.calory.text = (recipe.calories.toString())
        holder.time.text = recipe.time.toString().substring(2,4)+" min"

        for(i in favourite!!){
            if(i == recipe.id){
                holder.favourite.setImageResource(R.drawable.favourite)
            }
            else{
                holder.favourite.setImageResource(R.drawable.unfavourite)
            }
        }

        Glide.with(holder.itemView)
            .load(recipe.image)
            .into(holder.image)
    }

}