package com.example.recipeapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView

class RecipeAdapter(context: Context, private val dataSource: ArrayList<Recipe>): BaseAdapter(),
    Filterable {

    var recipe = dataSource
    var myFilter: FilterHelper =FilterHelper(dataSource,this)

    private var layoutInflater: LayoutInflater = context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE
    ) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val recipe = getItem(position)
        val viewHolder : ViewHolder
        val listItemRowView : View

        // convertView is null when executing for first time
        if ( convertView == null ) {
            listItemRowView = layoutInflater.inflate(R.layout.recipe_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.recipeTitle = listItemRowView.findViewById(R.id.recipe_title_txt)
            viewHolder.recipeDescription = listItemRowView.findViewById(R.id.recipe_description_txt)
            // setting view holder as tag to the row of list at this position (TAG)
            listItemRowView.tag = viewHolder
        } else {
            listItemRowView = convertView
            // setting viewHolder from the tag has been set in the if statement (TAG)
            viewHolder = listItemRowView.tag as ViewHolder
        }

        // setting information recipe object
        viewHolder.recipeTitle.text = recipe.mRecipeName
        viewHolder.recipeDescription.text = recipe.mRecipeDescription

        return listItemRowView
    }

    override fun getItem(position: Int): Recipe {
        return recipe[position]
    }

    override fun getItemId(position: Int): Long {
        return recipe[position].getRecipeId()
    }

    override fun getCount(): Int {
        return recipe.size
    }

    private class ViewHolder {
        lateinit var recipeTitle : TextView
        lateinit var recipeDescription : TextView
    }

    /*
    * For SearchView
     */
    override fun getFilter(): Filter {
        return myFilter
    }

    fun setFilter(arrayList: ArrayList<Recipe>) {
        recipe=arrayList
    }
}