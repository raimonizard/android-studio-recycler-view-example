package com.example.andoidstudio_recyclerview_demo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.model.PokemonTypeConverter

@Database(entities = arrayOf(Pokemon::class), version = 1)
@TypeConverters(PokemonTypeConverter::class)
// La classe CharacterDatabase hereta de RoomDatabase
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}