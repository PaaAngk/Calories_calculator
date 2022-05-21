package com.example.caloriescalculator.domain.usecase

import com.example.caloriescalculator.data.local.IngredientDao
import javax.inject.Inject

class RemoveIngredientUseCase @Inject constructor(
    private val ingredientDao: IngredientDao
) {

    fun removeIngredientById(id: Int) {
        ingredientDao.removeIngredientById(id)
    }
}