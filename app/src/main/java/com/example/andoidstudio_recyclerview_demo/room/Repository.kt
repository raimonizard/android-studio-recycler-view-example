package com.example.andoidstudio_recyclerview_demo.room
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

class Repository {
    val daoInterface = PokemonApplication.database.pokemonDao()

    suspend fun getFavorites(): MutableList<Pokemon> = daoInterface.getFavorites()
    suspend fun findByName(pokemon: Pokemon) = daoInterface.findByName(pokemon.name).isNotEmpty()
    suspend fun isFavorite(name: String): Boolean = daoInterface.isFavorite(name)
    suspend fun addFavorite(pokemon: Pokemon) = daoInterface.addFavorite(pokemon)
    suspend fun removeFavorite(pokemon: Pokemon) = daoInterface.removeFavorite(pokemon)
    suspend fun updateFavoriteStatus(name: String, isFavorite: Boolean) = daoInterface.updateFavoriteStatus(name, isFavorite)

}