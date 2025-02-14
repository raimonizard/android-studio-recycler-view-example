package com.example.andoidstudio_recyclerview_demo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import com.example.andoidstudio_recyclerview_demo.viewmodel.RoomViewModel

@Composable
fun LazyColumnPokedex(modifier: Modifier, navController: NavController, roomViewModel: RoomViewModel){
    roomViewModel.getPokemonList()
    val allPokemons: MutableList<Pokemon> by roomViewModel.allPokemon.observeAsState(mutableListOf())

    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxHeight()
        ) {
        item(){
            Button(onClick = {
                navController.navigate(Routes.LlistatFavPokemon.route)
            }) {
                Text("Pokédex")
            }
        }
        items(allPokemons){ pokemon ->
            PokemonItem(pokemon){
                navController.navigate(Routes.DetailScreen.createRoute(pokemon.name))
            }
        }
    }
}