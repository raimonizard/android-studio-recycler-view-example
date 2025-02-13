import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.andoidstudio_recyclerview_demo.viewmodel.getPokemonList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.andoidstudio_recyclerview_demo.room.PokemonDatabase

@Composable
fun DetailScreen(
    navController: NavController,
    pokemonName: String,
    context: Context, // Context is now a parameter
    modifier: Modifier = Modifier
) {
    // Busquem el pokémon per nom dins de la llista usant un for-each amb iterador
    val pokemon = remember { getPokemonList().find { it.name == pokemonName } }
    var isFavorite by remember { mutableStateOf(false) }

    // Initialize the database
    val db = remember {
        Room.databaseBuilder(
            context, // Use the passed context here
            PokemonDatabase::class.java, "pokemon-database"
        ).build()
    }

    // Load the favorite status from the database when the screen is first composed
    LaunchedEffect(pokemonName) {
        withContext(Dispatchers.IO) {
            val pokemonFromDb = db.pokemonDao().findByName(pokemonName)
            if (pokemonFromDb.isNotEmpty())
                isFavorite = pokemonFromDb?.get(0)!!.isFavorite ?: false
            else
                isFavorite = false
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(1.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (pokemon != null) {
                Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = pokemon.image),
                        contentDescription = pokemon.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(380.dp)
                            .clip(CircleShape)
                    )
                    IconButton(
                        onClick = {
                            isFavorite = !isFavorite
                            // Update the database in a coroutine
                            val pokemonToUpdate = pokemon.copy(isFavorite = isFavorite)
                            if (isFavorite) {
                                db.pokemonDao().addFavorite(pokemonToUpdate)
                            } else {
                                db.pokemonDao().updateFavoriteStatus(pokemonName, isFavorite)
                            }
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color.Red else Color.Gray,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = pokemon.name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Tipus: ${pokemon.type.name.lowercase().replaceFirstChar { it.uppercase() }}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = pokemon.type.color
                )

                Spacer(modifier = Modifier.height(24.dp))
            } else {
                Text(
                    text = "Pokémon no trobat",
                    fontSize = 22.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }

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
