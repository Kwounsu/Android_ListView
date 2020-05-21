package com.example.recipeapp

class Recipe (var mRecipeName:String, var mRecipeDescription:String) {
    fun getRecipeName():String{
        return mRecipeName
    }
    fun getRecipeDescription():String{
        return mRecipeDescription
    }
}