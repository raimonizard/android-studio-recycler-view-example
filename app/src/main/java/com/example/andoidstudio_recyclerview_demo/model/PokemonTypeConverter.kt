package com.example.andoidstudio_recyclerview_demo.model

import androidx.room.TypeConverter

class PokemonTypeConverter {
    @TypeConverter
    fun fromPokemonType(value: PokemonType): String {
        return value.name
    }

    @TypeConverter
    fun toPokemonType(value: String): PokemonType {
        return PokemonType.valueOf(value)
    }
}