package com.example.caloriescalculator.domain.model.converter

import androidx.room.TypeConverter
import com.example.caloriescalculator.domain.model.PokemonAbility
import com.example.caloriescalculator.domain.model.IngredientStat
import com.example.pokemonlibrary.domain.model.PokemonSprite

class StringConverter {

    @TypeConverter
    fun fromString(abilities: List<String>): String {
        return abilities.joinToString(",")
    }

    @TypeConverter
    fun toString(string: String): List<String> {
        return listOf(string)
    }
}

//string = PokemonAbility(ability=PokemonStat(name=magma-armor)
//list = PokemonAbility(ability=PokemonStat())