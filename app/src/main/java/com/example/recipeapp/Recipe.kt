package com.example.recipeapp

class Recipe (var recipeId:Int, var mRecipeName:String, var mRecipeDescription:String) {
    fun getRecipeName():String{
        return mRecipeName
    }
    fun getRecipeDescription():String{
        return mRecipeDescription
    }
    fun getRecipeId():Long{
        return recipeId.toLong()
    }
}