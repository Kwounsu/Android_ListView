package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class RecipeAdapter(private val context: Context,
                    private val dataSource: ArrayList<Recipe>): BaseAdapter() {

    private var layoutInflater: LayoutInflater = context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE
    ) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listItemRowView = layoutInflater.inflate(
            R.layout.recipe_list_item, parent, false)

        val recipe = getItem(position)

        listItemRowView.findViewById<TextView>(
            R.id.recipe_title_txt).setText(recipe.mRecipeName)
        listItemRowView.findViewById<TextView>(
            R.id.recipe_description_txt).setText(recipe.mRecipeDescription)

        return listItemRowView
    }

    override fun getItem(position: Int): Recipe {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return dataSource[position].getRecipeId()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}