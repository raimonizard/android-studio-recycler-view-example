package com.example.andoidstudio_recyclerview_demo.viewmodel

import com.example.andoidstudio_recyclerview_demo.R
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

fun getPokemonList(): MutableList<Pokemon>{
    val pokedex: MutableList<Pokemon> = mutableListOf()

    pokedex.add(Pokemon("Pikachu", "Electric", R.drawable.pikachu))
    pokedex.add(Pokemon("Charmander", "Fire", R.drawable.charmander))
    pokedex.add(Pokemon("Bulbasaur", "Grass", R.drawable.bulbasaur))
    pokedex.add(Pokemon("Squirtle", "Water", R.drawable.squirtle))
    pokedex.add(Pokemon("Jigglypuff", "Fairy", R.drawable.jigglypuff))
    pokedex.add(Pokemon("Meowth", "Normal", R.drawable.meowth))

    return pokedex
}