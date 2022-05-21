package com.example.caloriescalculator.data.repository

import com.example.caloriescalculator.data.local.IngredientDao
import com.example.caloriescalculator.domain.repository.IngredientRepository
import com.example.caloriescalculator.data.remote.IngredientsApi
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.pokemonlibrary.data.remote.IngredientApi
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20024
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class IngredientRepositoryImpl @Inject constructor(
    private val ingredientsApi: IngredientApi,
    private val ingredientDao: IngredientDao
): IngredientRepository {

    override fun Ingredient(ingredient: Ingredient) {
        //return ingredientDao.insertIngredient(ingredient)
        TODO("Not yet implemented")
    }

    override fun IngredientAuto(ingredient: InlineResponse20024) {
        TODO("Not yet implemented")
    }

    override fun removeIngredientById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun saveIngredientIdList(ids: List<InlineResponse20022>) {
        TODO("Not yet implemented")
    }

    override fun getIngredientIdList(): Single<List<InlineResponse20022>> {
        TODO("Not yet implemented")
    }

    override fun getIngredientAutoIdList(name: String): Observable<kotlin.Array<InlineResponse20024>> {
        return ingredientsApi.autocompleteIngredientSearch(apiKey = "ee7702764e8d40ebaa50edc9b104d9cd",name, intolerances = "", number = 30, metaInformation = true)
    }

    override fun getIngredientByName(name: String): Observable<InlineResponse20022> {
        TODO("Not yet implemented")
    }

    override fun getIngredientById(id: Int, amount: Int): Observable<Ingredient> {
        return ingredientsApi.getIngredientInfo(id = id,apiKey = "ee7702764e8d40ebaa50edc9b104d9cd",amount = amount, unit = "grams")
    }

    override fun getStatisticIngredientList(): Observable<List<Ingredient>> {
        return ingredientDao.getStatisticIngredientList()
    }

    override fun getIngredientsOverallData(offset: Int, limit: Int): Single<InlineResponse20022> {
        TODO("Not yet implemented")
    }


}
//    override fun saveIng(pokemon: Pokemon) {
//        return productDao.insertPokemon(pokemon)
//    }
//
//    override fun removePokemonById(id: Int) {
//        productDao.removePokemonById(id)
//    }
//
//    override fun savePokemonIdList(ids: List<PokemonId>) {
//        return productDao.insertIds(ids)
//    }
//
//    override fun getPokemonIdList(): Single<List<PokemonId>> {
//        return productDao.getPokemonIds()
//    }
//
//    override fun getPokemonByName(name: String): Observable<Pokemon> {
//        return pokeApi.getPokemonByName(name)
//    }
//
//    override fun getPokemonById(id: Int): Single<Pokemon> {
//        return pokeApi.getPokemonById(id)
//    }
//
//    override fun getFavoritePokemonList(): Observable<List<Pokemon>> {
//        return productDao.getFavoritePokemonList()
//    }
//
//    override fun getPokemonsOverallData(offset: Int, limit: Int): Single<PokemonOverallData> {
//        return pokeApi.getPokemonOverallData(offset = offset, limit = limit)
//    }