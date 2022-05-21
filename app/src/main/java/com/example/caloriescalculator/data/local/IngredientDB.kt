package com.example.caloriescalculator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.caloriescalculator.domain.model.Ingredient
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20024

@Database(entities = [Ingredient::class], version = 1)
abstract class IngredientDB: RoomDatabase() {
    abstract fun getIngredientDao(): IngredientDao
}