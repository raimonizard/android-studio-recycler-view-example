package com.example.andoidstudio_recyclerview_demo.view

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import com.example.andoidstudio_recyclerview_demo.viewmodel.RoomViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(
    modifier: Modifier,
    navController: NavController,
    roomViewModel: RoomViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(33, 48, 79))
    ) {

        val showLoading: Boolean by roomViewModel.loading.observeAsState(true)

        val favPokemon: MutableList<Pokemon> by roomViewModel.favorites.observeAsState(mutableListOf())
        roomViewModel.getFavorites()

        if (showLoading) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = Color.Companion.Black
            )
        } else {
            LazyColumn() {
                items(favPokemon) { pokemon ->
                    PokemonItem(pokemon) {
                        navController.navigate(Routes.DetailScreen.createRoute(pokemon.name))
                    }
                }

                item(){
                    Button(
                        onClick = {
                            navController.popBackStack()
                        },
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Text("Tornar enrere")
                    }
                }
            }
        }
    }
}
