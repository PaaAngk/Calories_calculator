package com.example.caloriescalculator.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_id")
data class PokemonId(
    @PrimaryKey val id: Int
)
