package com.example.caloriescalculator.presentation.adapter.ingredients

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.presentation.stat.FavoriteFragment

class IngredientAutoRecyclerViewAdapter(
    private val ingredientList: List<Ingredient>,
    private val activity: Activity,
    private val onIngredientCardClickListener: FavoriteFragment
): RecyclerView.Adapter<IngredientAutoRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientAutoRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return IngredientAutoRecyclerViewHolder(inflater, parent, activity, onIngredientCardClickListener)
    }

    override fun onBindViewHolder(holder: IngredientAutoRecyclerViewHolder, position: Int) {
        val ingredient: Ingredient = ingredientList[position]
        holder.bind(ingredient)
    }

    override fun getItemCount(): Int = ingredientList.size
}