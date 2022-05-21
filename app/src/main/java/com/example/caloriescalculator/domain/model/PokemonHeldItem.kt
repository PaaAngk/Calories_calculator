package com.example.caloriescalculator.domain.model

import com.example.caloriescalculator.domain.model.IngredientStat
import com.google.gson.annotations.SerializedName

data class PokemonHeldItem(
    @SerializedName("item") val item: IngredientStat
)
