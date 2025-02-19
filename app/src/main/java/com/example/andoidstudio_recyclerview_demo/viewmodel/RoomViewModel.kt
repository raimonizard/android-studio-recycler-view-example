package com.example.andoidstudio_recyclerview_demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andoidstudio_recyclerview_demo.R
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.model.PokemonType

import com.example.andoidstudio_recyclerview_demo.room.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomViewModel : ViewModel(){
    private val repository = Repository()

    private val _loading = MutableLiveData(true)
    val loading = _loading

    private val _isFavorite = MutableLiveData(false)
    val isFavorite = _isFavorite

    private val _favorites = MutableLiveData<MutableList<Pokemon>>()
    val favorites = _favorites

    private val _allPokemon = MutableLiveData<MutableList<Pokemon>>()
    val allPokemon = _allPokemon

    fun getPokemonList(){
        val pokedex: MutableList<Pokemon> = mutableListOf()

        pokedex.add(Pokemon("Pikachu", PokemonType.ELECTRIC, R.drawable.pikachu, false))
        pokedex.add(Pokemon("Charmander", PokemonType.FIRE, R.drawable.charmander, false))
        pokedex.add(Pokemon("Bulbasaur", PokemonType.GRASS, R.drawable.bulbasaur, false))
        pokedex.add(Pokemon("Squirtle", PokemonType.WATER, R.drawable.squirtle, false))
        pokedex.add(Pokemon("Jigglypuff", PokemonType.FAIRY, R.drawable.jigglypuff, false))
        pokedex.add(Pokemon("Meowth", PokemonType.NORMAL, R.drawable.meowth, false))
        pokedex.add(Pokemon("Psyduck", PokemonType.WATER, R.drawable.psyduck, false))
        pokedex.add(Pokemon("Gyarados", PokemonType.WATER, R.drawable.gyarados, false))
        pokedex.add(Pokemon("Alakazam", PokemonType.PSYCHIC, R.drawable.alakazam, false))
        pokedex.add(Pokemon("Golbat", PokemonType.POISON, R.drawable.golbat, false))

        _allPokemon.value = pokedex
    }

    fun getFavorites(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getFavorites()
            withContext(Dispatchers.Main){
                _favorites.value = response
                _loading.value = false
            }
        }
    }

    fun isFavorite(pokemon: Pokemon){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.isFavorite(pokemon.name)
            withContext(Dispatchers.Main){
                _isFavorite.value = response
            }
        }
    }

    fun saveAsFavorite(pokemon: Pokemon, onComplete: () -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addFavorite(pokemon)
            getFavorites()
            withContext(Dispatchers.Main) {
                _isFavorite.value = true
                onComplete()
            }
        }
    }

    fun deleteFavorite(pokemon: Pokemon){
        CoroutineScope(Dispatchers.IO).launch {
            repository.removeFavorite(pokemon)
            getFavorites()
            withContext(Dispatchers.Main){
                _isFavorite.value = false
            }
        }
    }

}