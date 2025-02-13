package com.example.andoidstudio_recyclerview_demo.room

import androidx.room.TypeConverter
import com.example.andoidstudio_recyclerview_demo.model.PokemonType

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