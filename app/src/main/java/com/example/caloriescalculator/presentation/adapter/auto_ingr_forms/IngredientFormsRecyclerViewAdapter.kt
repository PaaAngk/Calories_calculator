package com.example.caloriescalculator.presentation.adapter.auto_ingr_forms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class IngredientFormsRecyclerViewAdapter(
    private val stats: List<String>
): RecyclerView.Adapter<IngredientFormsRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientFormsRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return IngredientFormsRecyclerViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: IngredientFormsRecyclerViewHolder, position: Int) {
        val stat: String = stats[position]
        holder.bind(stat)
    }

    override fun getItemCount(): Int = stats.size
}