package com.example.recipeapp

import android.widget.Filter

open class FilterHelper(recipes:ArrayList<Recipe>,adaptor:RecipeAdapter) : Filter(){
    var AllRecipe=recipes
    var newAdaptor=adaptor
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var sonuc=FilterResults()

        if(constraint!=null && constraint.isNotEmpty()){
            var aranilanaAd=constraint.toString().toLowerCase()
            var eslesenler=ArrayList<Recipe>()
            for (recipe in AllRecipe){
                var adi=recipe.mRecipeName
                if (adi.contains(aranilanaAd)){
                    eslesenler.add(recipe)
                }
            }
            sonuc.values=eslesenler
            sonuc.count=eslesenler.size

        }else{
            sonuc.values=AllRecipe
            sonuc.count=AllRecipe.size
        }
        return sonuc
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        newAdaptor.setFilter(results?.values as ArrayList<Recipe>)
        newAdaptor.notifyDataSetChanged()
    }
}