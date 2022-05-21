package com.example.caloriescalculator.domain.model

import com.example.caloriescalculator.domain.model.IngredientStat
import com.google.gson.annotations.SerializedName

data class PokemonAbility(
    @SerializedName("possibleUnits") val possibleUnits: String
)