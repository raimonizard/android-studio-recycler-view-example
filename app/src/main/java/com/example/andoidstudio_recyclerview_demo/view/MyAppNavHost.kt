package com.example.andoidstudio_recyclerview_demo.view

import DetailScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import com.example.andoidstudio_recyclerview_demo.viewmodel.RoomViewModel

@Composable
fun MyAppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    roomViewModel: RoomViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(Routes.LlistatPokedex.route) {
            LazyColumnPokedex(navController, roomViewModel)
        }

        composable(Routes.LlistatFavPokemon.route) {
            FavoritesScreen(modifier, navController, roomViewModel)
        }

        composable(
            Routes.DetailScreen.route,
            arguments = listOf(
                navArgument("pokemonName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailScreen(
                navController,
                // Per si de cas el nom del pokémon és buit, li passarem una cadena de caràcters buida al cridar la view
                backStackEntry.arguments?.getString("pokemonName").orEmpty(),
                modifier,
                roomViewModel
            )
        }
    }
}
