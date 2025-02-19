package com.example.andoidstudio_recyclerview_demo.nav

sealed class Routes(val route: String){
    object SplashScreen: Routes("SplashScreen")

    object LlistatPokedex: Routes("LazyColumnPokedex")

    object LlistatFavPokemon: Routes("FavouritesScreen")

    object DetailScreen: Routes("DetailScreen/{pokemonName}") {
        fun createRoute(pokemonName: String) = "DetailScreen/$pokemonName"
    }
}