package com.example.andoidstudio_recyclerview_demo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.andoidstudio_recyclerview_demo.model.Character
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

@Database(entities = arrayOf(Pokemon::class), version = 1)
@TypeConverters(PokemonTypeConverter::class)
// La classe CharacterDatabase hereta de RoomDatabase
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}