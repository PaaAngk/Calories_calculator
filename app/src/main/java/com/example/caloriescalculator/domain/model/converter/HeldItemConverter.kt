package com.example.caloriescalculator.domain.model.converter

import androidx.room.TypeConverter
import com.example.caloriescalculator.domain.model.PokemonHeldItem
import com.example.caloriescalculator.domain.model.IngredientStat

class HeldItemConverter {

    @TypeConverter
    fun fromHeldItem(heldItems: List<PokemonHeldItem>): String {
        return heldItems.joinToString(",")
    }

    @TypeConverter
    fun toHeldItem(heldItemsString: String): List<PokemonHeldItem> {
        if (heldItemsString.isEmpty()) return emptyList()
        return heldItemsString.split(",").map {
            PokemonHeldItem(
                IngredientStat(it.substringAfter("name=").substringBefore(')'))
            )
        }
    }
}