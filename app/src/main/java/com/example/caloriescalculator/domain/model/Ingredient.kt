package com.example.caloriescalculator.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.caloriescalculator.domain.model.converter.StringConverter
import com.example.caloriescalculator.domain.model.converter.InlineResponse20022NutritionConverter
import com.example.caloriescalculator.domain.model.converter.HeldItemConverter
import com.google.gson.annotations.SerializedName
import com.spoonacular.client.model.InlineResponse20022Nutrition

@Entity(tableName = "ingredient_table")
@TypeConverters(
    StringConverter::class,
    InlineResponse20022NutritionConverter::class,
    StringConverter::class,
    HeldItemConverter::class
)
data class Ingredient(
    @SerializedName("id")
    @PrimaryKey val id: Int,

    @SerializedName("original")
    val original: String? = null,

    @SerializedName("originalName")
    val originalName: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("nameClean")
    val nameClean: String? = null,

    @SerializedName("amount")
    val amount: Double? = null,

    @SerializedName("unit")
    val unit: String? = null,

    @SerializedName("unitShort")
    val unitShort: String? = null,

    @SerializedName("unitLong")
    val unitLong: String? = null,

    @SerializedName("possibleUnits")
    val possibleUnits: List<String>? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("nutrition")
    val nutrition: InlineResponse20022Nutrition? = null,
)
//@SerializedName("shoppingListUnits")
//private val shoppingListUnits: List<String>? = null,

//    @SerializedName("estimatedCost")
//    private val estimatedCost: RecipesParseIngredientsEstimatedCost? = null,

//    @SerializedName("consistency")
//    private val consistency: String? = null,


//    @SerializedName("categoryPath")
//    private val categoryPath: List<String>? = null
//    @SerializedName("meta")
//    private val meta: List<Any>? = null,

//    @SerializedName("aisle")
//    private val aisle: String? = null,