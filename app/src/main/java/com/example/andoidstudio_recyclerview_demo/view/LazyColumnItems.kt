package com.example.andoidstudio_recyclerview_demo.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExempleLazyColumnItems(modifier: Modifier = Modifier) {
    LazyColumn(
        Modifier
        .padding(vertical = 25.dp)
        .fillMaxHeight(0.80f)
    ) {
        item {
            Text(
                text = "Llistat de 10 elements:",
                style = MaterialTheme.typography.headlineMedium, // Fa el text més gran
                modifier = Modifier
                    .padding(8.dp) // Afegim espai al voltant
                    .background(Color.LightGray, shape = RoundedCornerShape(4.dp)) // Fons gris clar i cantonades arrodonides
                    .padding(16.dp), // Espai dins el fons
                color = MaterialTheme.colorScheme.primary // Color principal de la teva app
            )
        }
        items(10) {
                Text(text = "\t- Item $it")
        }
    }
}