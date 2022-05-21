package com.example.caloriescalculator.domain.usecase

import com.example.caloriescalculator.domain.repository.IngredientRepository
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20024
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetIngredientAutoUseCase @Inject constructor(
    private val repository: IngredientRepository
) {
    fun get(name: String): Observable<kotlin.Array<InlineResponse20024>> = repository.getIngredientAutoIdList(name = name)

    //fun get(id: Int): Single<InlineResponse20022> = repository.getIngredientById(id = id)

    fun getIngredientIds(): Single<List<InlineResponse20022>> = repository.getIngredientIdList()

    //fun getFavoriteIngredientList(): Observable<List<InlineResponse20022>> = repository.getFavoriteIngredientList()
}