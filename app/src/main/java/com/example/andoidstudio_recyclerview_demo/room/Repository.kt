package com.example.andoidstudio_recyclerview_demo.room
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

class Repository {
    val daoInterface = PokemonApplication.database.pokemonDao()

    suspend fun getCaptured(): MutableList<Pokemon> = daoInterface.getCaptured()
    suspend fun findByName(pokemon: Pokemon) = daoInterface.findByName(pokemon.name).isNotEmpty()
    suspend fun isCaptured(name: String): Boolean = daoInterface.isCaptured(name)
    suspend fun capturePokemon(pokemon: Pokemon) = daoInterface.capturePokemon(pokemon)
    suspend fun freePokemon(pokemon: Pokemon) = daoInterface.freePokemon(pokemon)
    suspend fun updateCapturedStatus(name: String, isCaptured: Boolean) = daoInterface.updateCapturedStatus(name, isCaptured)

}