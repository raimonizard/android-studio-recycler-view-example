package com.example.andoidstudio_recyclerview_demo.room
import com.example.andoidstudio_recyclerview_demo.model.Character

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


interface CharacterDao {
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): MutableList<Character>

    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Int): MutableList<Character>

    @Insert
    suspend fun addCharacter(character: Character)

    @Delete
    suspend fun deleteCharacter(character: Character)
}