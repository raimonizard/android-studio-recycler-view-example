package com.example.andoidstudio_recyclerview_demo.view

import DetailScreen
import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.andoidstudio_recyclerview_demo.nav.Routes.DetailScreen

@Composable
fun MyAppNavHost(modifier: Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.LlistatPokedex.route
    ) {
        composable(Routes.LlistatPokedex.route) {
            LazyColumnPokedex(modifier, navController)
        }

        composable(
                Routes.DetailScreen.route,
                arguments = listOf(
                    navArgument("pokemonName") { type = NavType.StringType }
                )
            ) {backStackEntry ->
            DetailScreen(
                modifier,
                navController,
                // Per si de cas el nom del pokémon és buit, li passarem una cadena de caràcters buida al cridar la view
                backStackEntry.arguments?.getString("pokemonName").orEmpty()
            )
        }
    }
}
