package com.example.caloriescalculator.domain.repository

import com.example.caloriescalculator.domain.model.Ingredient
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20024
import com.spoonacular.client.model.InlineResponse20025
import com.spoonacular.client.model.InlineResponse20025Results
import io.reactivex.Observable
import io.reactivex.Single

interface IngredientRepository {

    fun Ingredient(ingredient: Ingredient)

    fun IngredientAuto(ingredient: InlineResponse20024)

    fun removeIngredientById(id: Int)

    fun saveIngredientIdList(ids: List<InlineResponse20022>)

    fun getIngredientIdList(): Single<List<InlineResponse20022>>

    //Auto
    fun getIngredientAutoIdList(name: String): Observable<kotlin.Array<InlineResponse20024>>

    fun getIngredientByName(name: String): Observable<InlineResponse20022>

    //id
    fun getIngredientById(id: Int, amount: Int): Observable<Ingredient>

    fun getStatisticIngredientList(): Observable<List<Ingredient>>

    fun getIngredientsOverallData(offset: Int, limit: Int): Single<InlineResponse20022>
}