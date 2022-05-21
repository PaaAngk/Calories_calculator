package com.example.caloriescalculator.di

//import com.example.pokemonlibrary.data.remote.PokeApi
//import com.example.caloriescalculator.data.remote.PokeApiClient
import com.example.caloriescalculator.data.remote.IngredientApiClient
import com.example.caloriescalculator.data.remote.IngredientsApi
import com.example.pokemonlibrary.data.remote.IngredientApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(): IngredientApi {
        return IngredientApiClient.getClient()
    }
}