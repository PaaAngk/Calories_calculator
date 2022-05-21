package com.example.pokemonlibrary.data.remote

//import com.example.pokemonlibrary.domain.model.Pokemon
import com.example.caloriescalculator.domain.model.Ingredient
import com.example.pokemonlibrary.domain.model.PokemonOverallData
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20024
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IngredientApi {

    @GET("/food/ingredients/autocomplete")
    fun autocompleteIngredientSearch(
        @Query("apiKey") apiKey: String,
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("metaInformation") metaInformation: Boolean,
        @Query("intolerances") intolerances: String
    ): Observable<kotlin.Array<InlineResponse20024>>

    @GET("/food/ingredients/{id}/information")
    fun getIngredientInfo(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String,
        @Query("amount") amount: Int,
        @Query("unit") unit: String
    ): Observable<Ingredient>

//    @GET("pokemon/{id}")
//    fun getPokemonById(@Path("id") id: Int): Single<Pokemon>
}