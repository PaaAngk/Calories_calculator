package com.example.caloriescalculator.presentation.adapter.ingredients

import com.example.caloriescalculator.domain.model.Ingredient
import com.spoonacular.client.model.InlineResponse20022

interface OnIngredientCardClickListener {

    fun onRemoveFromFavoriteClicked(ingredient: Ingredient, position: Int)
}