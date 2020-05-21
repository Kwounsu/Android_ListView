package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recipeListView : ListView

    // ListView <-- Adaptor <-- Data Source (db, file, network)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recipeListView = findViewById(R.id.recipe_list)
//        val recipeAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getRecipeTitles())
        val recipeAdapter = RecipeAdapter(this, getRecipes())
        recipeListView.adapter = recipeAdapter
    }

    fun getRecipeTitles():ArrayList<String> {
        val recipeList = getRecipes()
        val recipesTitleList:ArrayList<String> = ArrayList()
        for (i in 0 until recipeList.size) {
            // calling getView
            recipesTitleList.add(recipeList[i].mRecipeName)
        }
        return recipesTitleList
    }

    // Data Source
    fun getRecipes():ArrayList<Recipe> {
        val recipes:ArrayList<Recipe> = ArrayList()
        recipes.add(Recipe("Burritos", "Burritos recipe"))
        recipes.add(Recipe("Noodle", "Noodle recipe"))
        recipes.add(Recipe("Pasta", "Pasta recipe"))
        recipes.add(Recipe("Cake", "Cake recipe"))
        recipes.add(Recipe("Muffin", "Muffin recipe"))
        recipes.add(Recipe("Korean BBQ", "Korean BBQ recipe"))
        recipes.add(Recipe("Steak", "Steak recipe"))
        recipes.add(Recipe("Pizza", "Pizza recipe"))
        recipes.add(Recipe("Burger", "Burger recipe"))
        recipes.add(Recipe("Rice Cake", "Rice Cake recipe"))
        recipes.add(Recipe("Orange Chicken", "Orange Chicken recipe"))
        recipes.add(Recipe("Poison", "Poison recipe"))
        recipes.add(Recipe("Health Potion", "Health Potion recipe"))
        recipes.add(Recipe("Mana Potion", "Mana Potion recipe"))
        recipes.add(Recipe("Sword", "Sword recipe"))
        recipes.add(Recipe("Legendary Sword", "Legendary Sword recipe"))
        recipes.add(Recipe("Shield", "Shield recipe"))
        recipes.add(Recipe("Bow", "Bow recipe"))
        recipes.add(Recipe("Crossbow", "Crossbow recipe"))
        recipes.add(Recipe("Arrow", "Arrow recipe"))
        recipes.add(Recipe("Bolt", "Bolt recipe"))
        return recipes
    }
}
