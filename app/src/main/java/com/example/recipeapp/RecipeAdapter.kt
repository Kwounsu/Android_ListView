package com.example.recipeapp

import android.content.Context
import android.util.Log
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

        val recipe = getItem(position)
        val viewHolder : ViewHolder
        val listItemRowView : View

        // convertView iss null when executing for first time
        if ( convertView == null ) {
            listItemRowView = layoutInflater.inflate(R.layout.recipe_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.recipeTitle = listItemRowView.findViewById(R.id.recipe_title_txt)
            viewHolder.recipeDescription = listItemRowView.findViewById(R.id.recipe_description_txt)
            // setting view holder as tag to the row of list at this position
            listItemRowView.tag = viewHolder
            Log.d("RecipeApp","==>getView() $position ==> convert == null")
        } else {
            listItemRowView = convertView
            viewHolder = listItemRowView.tag as ViewHolder
            Log.d("RecipeApp","==>getView() $position ==> convert != null")
        }

        // setting information recipe object
        viewHolder.recipeTitle.text = recipe.mRecipeName
        viewHolder.recipeDescription.text = recipe.mRecipeDescription

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

    private class ViewHolder {
        lateinit var recipeTitle : TextView
        lateinit var recipeDescription : TextView
    }

}