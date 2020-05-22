package com.example.recipeapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var recipeListView : ListView

    // ListView <--> Adaptor <--> Data Source (db, file, network)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recipeListView = findViewById(R.id.recipe_list)
        // Using Default adapter
//        val recipeAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getRecipeTitles())
        // Using Custom adapter
        val recipeAdapter = RecipeAdapter(this, getRecipes())
        recipeListView.adapter = recipeAdapter
    }

//    fun getRecipeTitles():ArrayList<String> {
//        val recipeList = getRecipes()
//        val recipesTitleList:ArrayList<String> = ArrayList()
//        for (i in 0 until recipeList.size) {
//            // calling getView
//            recipesTitleList.add(recipeList[i].mRecipeName)
//        }
//        return recipesTitleList
//    }

    // Data Source
    fun getRecipes():ArrayList<Recipe> {
        val recipes:ArrayList<Recipe> = ArrayList()
        recipes.add(Recipe(1, "Burritos", "Burritos recipe"))
        recipes.add(Recipe(2, "Noodle", "Noodle recipe"))
        recipes.add(Recipe(3, "Pasta", "Pasta recipe"))
        recipes.add(Recipe(4, "Cake", "Cake recipe"))
        recipes.add(Recipe(5, "Muffin", "Muffin recipe"))
        recipes.add(Recipe(6, "Korean BBQ", "Korean BBQ recipe"))
        recipes.add(Recipe(7, "Steak", "Steak recipe"))
        recipes.add(Recipe(8, "Pizza", "Pizza recipe"))
        recipes.add(Recipe(9, "Burger", "Burger recipe"))
        recipes.add(Recipe(10, "Rice Cake", "Rice Cake recipe"))
        recipes.add(Recipe(11, "Orange Chicken", "Orange Chicken recipe"))
        recipes.add(Recipe(12, "Poison", "Poison recipe"))
        recipes.add(Recipe(13, "Health Potion", "Health Potion recipe"))
        recipes.add(Recipe(14, "Mana Potion", "Mana Potion recipe"))
        recipes.add(Recipe(15, "Sword", "Sword recipe"))
        recipes.add(Recipe(16, "Legendary Sword", "Legendary Sword recipe"))
        recipes.add(Recipe(17, "Shield", "Shield recipe"))
        recipes.add(Recipe(18, "Bow", "Bow recipe"))
        recipes.add(Recipe(19, "Crossbow", "Crossbow recipe"))
        recipes.add(Recipe(20, "Arrow", "Arrow recipe"))
        recipes.add(Recipe(21, "Bolt", "Bolt recipe"))
        return recipes
    }
}
