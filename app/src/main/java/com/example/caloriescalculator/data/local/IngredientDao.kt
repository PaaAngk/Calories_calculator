package com.example.caloriescalculator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.caloriescalculator.domain.model.Ingredient
import com.spoonacular.client.model.InlineResponse20022
import com.spoonacular.client.model.InlineResponse20025Results
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface IngredientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredient(ingredient: Ingredient)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIds(ids: List<Ingredient>)

//    @Query("SELECT * FROM ingredient")
//    fun getIngredientIds(): Single<List<InlineResponse20022>>

    @Query("SELECT * FROM ingredient_table")
    fun getStatisticIngredientList(): Observable<List<Ingredient>>

    @Query("DELETE FROM ingredient_table WHERE id = :id")
    fun removeIngredientById(id: Int)
}