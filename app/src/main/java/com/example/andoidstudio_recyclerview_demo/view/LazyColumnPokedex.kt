package com.example.andoidstudio_recyclerview_demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import com.example.andoidstudio_recyclerview_demo.viewmodel.getPokemonList

@Composable
fun LazyColumnPokedex(modifier: Modifier, navController: NavController){
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxHeight()
        ) {
        items(getPokemonList()){ pokemon ->
            PokemonItem(pokemon = pokemon){
                navController.navigate(Routes.DetailScreen.createRoute(pokemon.name))
            }
        }
    }
}