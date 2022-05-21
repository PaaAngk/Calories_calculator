package com.example.caloriescalculator.domain.model

import com.google.gson.annotations.SerializedName

data class IngredientStat(
    @SerializedName("name") val name: String
)
