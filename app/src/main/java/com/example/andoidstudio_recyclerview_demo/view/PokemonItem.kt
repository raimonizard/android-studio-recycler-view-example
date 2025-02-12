package com.example.andoidstudio_recyclerview_demo.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

@Composable
fun PokemonItem(pokemon: Pokemon, onSelectedItem: (String) -> Unit) {
    Card(
        border = BorderStroke(2.dp, pokemon.type.color),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelectedItem(pokemon.name) }
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight()
                        .background(pokemon.type.color)
                )
                Column {
                    Text(
                        text = pokemon.name,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = pokemon.type.name.lowercase().replaceFirstChar { it.uppercase() },
                        color = pokemon.type.color,
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = pokemon.type.color,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}