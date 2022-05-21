package com.example.caloriescalculator.domain.model.converter

import androidx.room.TypeConverter
import com.example.caloriescalculator.domain.model.IngredientStat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.spoonacular.client.model.InlineResponse20022Nutrition
import java.lang.reflect.Type
import java.util.stream.Collectors

class InlineResponse20022NutritionConverter {

    @TypeConverter
    fun fromForm(forms: InlineResponse20022Nutrition): String {
        return Gson().toJson(forms).toString()
    }

    @TypeConverter
    fun toForm(string: String): InlineResponse20022Nutrition {
        val listType: Type = object : TypeToken<InlineResponse20022Nutrition?>() {}.type
        return Gson().fromJson(string, listType)
    }
}