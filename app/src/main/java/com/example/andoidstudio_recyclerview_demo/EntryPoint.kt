package com.example.andoidstudio_recyclerview_demo

import com.example.andoidstudio_recyclerview_demo.view.*

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.andoidstudio_recyclerview_demo.ui.theme.AndoidStudioRecyclerViewdemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoidStudioRecyclerViewdemoTheme {
                val navController = rememberNavController() // Inicialitza el NavController
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "pokedex"
                    ) {
                        composable("pokedex") {
                            LazyColumnPokedex(navController = navController, Modifier.padding(innerPadding))
                        }
                        composable("detail_screen/{pokemonName}") { backStackEntry ->
                            val pokemonName = backStackEntry.arguments?.getString("pokemonName")
                            DetailScreen(pokemonName)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEscena() {
    AndoidStudioRecyclerViewdemoTheme {
        ExempleLazyColumnItem()
    }
}