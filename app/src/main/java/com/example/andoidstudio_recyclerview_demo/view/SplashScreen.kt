package com.example.andoidstudio_recyclerview_demo.view

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.andoidstudio_recyclerview_demo.R
import com.example.andoidstudio_recyclerview_demo.nav.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var rotation by remember { mutableStateOf(0f) }

    val infiniteTransition = rememberInfiniteTransition()
    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    LaunchedEffect(Unit) {
        delay(3000) // Simula una càrrega de 3 segons
        navController.navigate(Routes.LlistatPokedex.route) {
            popUpTo(Routes.SplashScreen.route) { inclusive = true }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = "Catch'em all!",
            modifier = Modifier
                .size(150.dp)
                .rotate(rotateAnimation) // Aplica la rotació animada
        )
    }
}
