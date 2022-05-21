package com.example.caloriescalculator.domain.usecase

import android.util.Log
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.caloriescalculator.domain.repository.IngredientRepository
import com.spoonacular.client.model.InlineResponse20022
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetIngredientInfoUseCase @Inject constructor(
    private val repository: IngredientRepository
) {

    fun getIngredientById(id: Int, amount: Int): Observable<Ingredient> {
        return repository.getIngredientById(id = id, amount = amount)
    }

    fun getIngredientList(): Observable<List<Ingredient>> {
        return repository.getStatisticIngredientList()
    }
}