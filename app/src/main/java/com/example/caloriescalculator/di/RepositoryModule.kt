package com.example.caloriescalculator.di

import com.example.caloriescalculator.data.local.IngredientDao
import com.example.caloriescalculator.data.repository.IngredientRepositoryImpl
import com.example.caloriescalculator.domain.repository.IngredientRepository
import com.example.caloriescalculator.data.remote.IngredientsApi
import com.example.pokemonlibrary.data.remote.IngredientApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providePokemonRepository(ingredientsApi: IngredientApi, ingredientDao: IngredientDao): IngredientRepository {
        return IngredientRepositoryImpl(ingredientsApi = ingredientsApi, ingredientDao = ingredientDao)
    }
}