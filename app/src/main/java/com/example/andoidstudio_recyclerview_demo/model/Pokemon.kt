package com.example.andoidstudio_recyclerview_demo.model

import androidx.annotation.DrawableRes
// Necessari importar per poder usar persistència de dades
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pokemons")
data class Pokemon(
    @PrimaryKey var name: String,
    var type: PokemonType,
    // És de tipus Int perquè internament Android Studio assigna un valor enter a cada element drawable
    @DrawableRes var image: Int
)