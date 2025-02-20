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

    private val _isCaptured = MutableLiveData(false)
    val isCaptured = _isCaptured

    private val _captured = MutableLiveData<MutableList<Pokemon>>()
    val captured = _captured

    private val _allPokemon = MutableLiveData<MutableList<Pokemon>>()
    val allPokemon = _allPokemon

    private val _isCatchingPokemon = MutableLiveData(false)
    val isCatchingPokemon = _isCatchingPokemon

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

    fun getCaptured(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getCaptured()
            withContext(Dispatchers.Main){
                _captured.value = response
                _loading.value = false
            }
        }
    }

    fun isCaptured(pokemon: Pokemon){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.isCaptured(pokemon.name)
            withContext(Dispatchers.Main){
                _isCaptured.value = response
            }
        }
    }

    fun capturePokemon(pokemon: Pokemon, onComplete: () -> Unit){
        CoroutineScope(Dispatchers.IO).launch {
            repository.capturePokemon(pokemon)
            getCaptured()
            withContext(Dispatchers.Main) {
                _isCaptured.value = true
                onComplete()
            }
        }
    }

    fun freePokemon(pokemon: Pokemon){
        CoroutineScope(Dispatchers.IO).launch {
            repository.freePokemon(pokemon)
            getCaptured()
            withContext(Dispatchers.Main){
                _isCaptured.value = false
            }
        }
    }

}