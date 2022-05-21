package com.example.caloriescalculator.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.caloriescalculator.domain.model.converter.StringConverter
import com.example.caloriescalculator.domain.model.converter.InlineResponse20022NutritionConverter
import com.example.caloriescalculator.domain.model.converter.HeldItemConverter
import com.example.pokemonlibrary.domain.model.converter.SpriteConverter
import com.google.gson.annotations.SerializedName
import com.spoonacular.client.model.InlineResponse20022Nutrition
import com.spoonacular.client.model.RecipesParseIngredientsEstimatedCost
import java.math.BigDecimal

@Entity(tableName = "ingredient_table")
@TypeConverters(
    SpriteConverter::class,
    InlineResponse20022NutritionConverter::class,
    StringConverter::class,
    HeldItemConverter::class
)
data class IngredientAuto(
    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("original")
    private val original: String? = null,

    @SerializedName("originalName")
    private val originalName: String? = null,

    @SerializedName("name")
    private val name: String? = null,

    @SerializedName("nameClean")
    private val nameClean: String? = null,

    @SerializedName("amount")
    private val amount: BigDecimal? = null,

    @SerializedName("unit")
    private val unit: String? = null,

    @SerializedName("unitShort")
    private val unitShort: String? = null,

    @SerializedName("unitLong")
    private val unitLong: String? = null,

    @SerializedName("possibleUnits")
    private val possibleUnits: List<String>? = null,

    @SerializedName("estimatedCost")
    private val estimatedCost: RecipesParseIngredientsEstimatedCost? = null,

    @SerializedName("consistency")
    private val consistency: String? = null,

    @SerializedName("shoppingListUnits")
    private val shoppingListUnits: List<String>? = null,

    @SerializedName("aisle")
    private val aisle: String? = null,

    @SerializedName("image")
    private val image: String? = null,

    @SerializedName("meta")
    private val meta: List<Any>? = null,

    @SerializedName("nutrition")
    private val nutrition: InlineResponse20022Nutrition? = null,

    @SerializedName("categoryPath")
    private val categoryPath: List<String>? = null
)