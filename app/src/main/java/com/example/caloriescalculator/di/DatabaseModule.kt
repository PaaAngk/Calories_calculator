package com.example.caloriescalculator.di

import android.content.Context
import android.provider.DocumentsContract
import androidx.room.Room
import com.example.caloriescalculator.data.local.IngredientDB
import com.example.caloriescalculator.data.local.IngredientDao
//import com.example.pokemonlibrary.data.local.PokeDB
//import com.example.pokemonlibrary.data.local.PokeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): IngredientDB {
        return Room.databaseBuilder(
            context,
            IngredientDB::class.java,
            "ingredient_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providePokeDao(ingredientDB: IngredientDB): IngredientDao {
        return ingredientDB.getIngredientDao()
    }
}