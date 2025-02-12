package com.example.andoidstudio_recyclerview_demo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.andoidstudio_recyclerview_demo.model.Character

@Database(entities = arrayOf(Character::class), version = 1)
@TypeConverters(Converters::class)
// La classe CharacterDatabase hereta de RoomDatabase
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}