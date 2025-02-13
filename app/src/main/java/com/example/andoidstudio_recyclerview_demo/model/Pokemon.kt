package com.example.andoidstudio_recyclerview_demo.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
// Necessari importar per poder usar persistència de dades
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.andoidstudio_recyclerview_demo.room.PokemonTypeConverter

@Entity(tableName = "pokemons")
@TypeConverters(PokemonTypeConverter::class)
data class Pokemon(
    @PrimaryKey val name: String, // Primary key for Room
    val type: PokemonType,
    // És de tipus Int perquè internament Android Studio assigna un valor enter a cada element drawable
    @DrawableRes val image: Int,
    @ColumnInfo(name = "is_favorite") var isFavorite: Boolean = false // Add isFavorite field
)
