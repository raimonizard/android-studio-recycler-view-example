package com.example.andoidstudio_recyclerview_demo.room
import com.example.andoidstudio_recyclerview_demo.model.Character
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

class Repository {
    val daoInterface = PokemonApplication.database.pokemonDao()

    // Database functions
    suspend fun addFavorite(pokemon: Pokemon) = daoInterface.addFavorite(pokemon)
    suspend fun removeFavorite(pokemon: Pokemon) = daoInterface.removeFavorite(pokemon)
    suspend fun findByName(character: Character) = daoInterface.findByName(character.name).isNotEmpty()
    suspend fun getFavorites() = daoInterface.getAll()
}