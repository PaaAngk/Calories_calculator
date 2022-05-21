package com.example.caloriescalculator.domain.usecase

import com.example.caloriescalculator.data.local.IngredientDao
import com.example.caloriescalculator.domain.model.Ingredient
import com.spoonacular.client.model.InlineResponse20022
import io.reactivex.Single
import javax.inject.Inject

class SaveIngredientUseCase @Inject constructor(
    private val ingredientDao: IngredientDao
) {

    fun saveIngredient(ingredient: Ingredient) {

        ingredientDao.insertIngredient(ingredient)
    }

    fun saveIngredientIds(ids: List<Ingredient>) {
        ingredientDao.insertIds(ids)
    }
}