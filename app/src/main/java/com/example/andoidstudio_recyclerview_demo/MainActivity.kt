package com.example.andoidstudio_recyclerview_demo

import com.example.andoidstudio_recyclerview_demo.view.*

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.andoidstudio_recyclerview_demo.ui.theme.AndoidStudioRecyclerViewdemoTheme
import com.example.andoidstudio_recyclerview_demo.viewmodel.RoomViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val roomViewModel by viewModels<RoomViewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndoidStudioRecyclerViewdemoTheme {
                Scaffold(
                    modifier = Modifier
                    .fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController() // Inicialitza el NavController
                    MyAppNavHost(Modifier.padding(innerPadding), navController, roomViewModel)
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewEscena() {
    AndoidStudioRecyclerViewdemoTheme {
        ExempleLazyColumnItem()
    }
}
*/