package com.example.caloriescalculator.data.remote

import com.example.pokemonlibrary.data.remote.IngredientApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.spoonacular.com"

object IngredientApiClient {

    fun getClient(): IngredientApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IngredientApi::class.java)
    }
}