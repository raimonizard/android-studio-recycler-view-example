package com.example.andoidstudio_recyclerview_demo.room
import com.example.andoidstudio_recyclerview_demo.model.Character

class Repository {
    val daoInterface = CharacterApplication.database.characterDao()

    // Database functions
    suspend fun saveAsFavorite(character: Character) = daoInterface.addCharacter(character)
    suspend fun deleteFavorite(character: Character) = daoInterface.deleteCharacter(character)
    suspend fun isFavorite(character: Character) = daoInterface.getCharacterById(character.id)
    suspend fun getFavorites() = daoInterface.getAllCharacters()
}