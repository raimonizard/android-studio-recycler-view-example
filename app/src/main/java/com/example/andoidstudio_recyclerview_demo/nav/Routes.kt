package com.example.andoidstudio_recyclerview_demo.nav

sealed class Routes(val route: String){
    object LlistatPokedex: Routes("LazyColumnPokedex")

    object DetailScreen: Routes("DetailScreen/{pokemonName}") {
        fun createRoute(pokemonName: String) = "DetailScreen/$pokemonName"
    }
}