package com.example.andoidstudio_recyclerview_demo.viewmodel

import com.example.andoidstudio_recyclerview_demo.R
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.model.PokemonType

fun getPokemonList(): MutableList<Pokemon>{
    val pokedex: MutableList<Pokemon> = mutableListOf()

    pokedex.add(Pokemon("Pikachu", PokemonType.ELECTRIC, R.drawable.pikachu))
    pokedex.add(Pokemon("Charmander", PokemonType.FIRE, R.drawable.charmander))
    pokedex.add(Pokemon("Bulbasaur", PokemonType.GRASS, R.drawable.bulbasaur))
    pokedex.add(Pokemon("Squirtle", PokemonType.WATER, R.drawable.squirtle))
    pokedex.add(Pokemon("Jigglypuff", PokemonType.FAIRY, R.drawable.jigglypuff))
    pokedex.add(Pokemon("Meowth", PokemonType.NORMAL, R.drawable.meowth))
    pokedex.add(Pokemon("Psyduck", PokemonType.WATER, R.drawable.psyduck))
    pokedex.add(Pokemon("Gyarados", PokemonType.WATER, R.drawable.gyarados))
    pokedex.add(Pokemon("Alakazam", PokemonType.PSYCHIC, R.drawable.alakazam))
    pokedex.add(Pokemon("Golbat", PokemonType.POISON, R.drawable.golbat))

    return pokedex
}