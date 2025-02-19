import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.andoidstudio_recyclerview_demo.R
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.andoidstudio_recyclerview_demo.viewmodel.RoomViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    pokemonName: String,
    modifier: Modifier = Modifier,
    roomViewModel: RoomViewModel
) {
    /*
    // Busquem el pokémon pel nom dins de la llista live data de allPokemon del ViewModel usant un for-each amb iterador
    val allPokemons: MutableList<Pokemon> by roomViewModel.allPokemon.observeAsState(mutableListOf())
    val pokemon = remember { allPokemons.find { it.name == pokemonName } }!!

    var isCatchingPokemon by remember { mutableStateOf(false) }

    // Carregar tots els pokemons favorits dins de la variable favorites del ViewModel
    roomViewModel.getFavorites()
    val favorites: MutableList<Pokemon> by roomViewModel.favorites.observeAsState(mutableListOf())

    // Executem la funció isFavorite del ViewModel per tal de que consulti si el pokémon escollit era ja favorit abans de clickar-lo
    roomViewModel.isFavorite(pokemon)
    val isFavorite: Boolean by roomViewModel.isFavorite.observeAsState(false)
    */

    val allPokemons by roomViewModel.allPokemon.observeAsState(mutableListOf())
    val favorites by roomViewModel.favorites.observeAsState(mutableListOf())
    val isFavorite by roomViewModel.isFavorite.observeAsState(false)

    // Buscar el Pokémon pel nom
    val pokemon = allPokemons.find { it.name == pokemonName }

    var isCatchingPokemon by remember { mutableStateOf(false) }

    // Cridem només una vegada quan `pokemon` canvia
    LaunchedEffect(pokemon) {
        pokemon?.let {
            roomViewModel.isFavorite(it)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (pokemon != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Take up available space
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = if (isFavorite) 2.dp else 0.dp,
                            color = pokemon.type.color,
                            shape = CircleShape
                        )
                )
// Substituïm l'Icon per una imatge PNG
                Image(
                    painter = painterResource(id = if (isFavorite) R.drawable.pokeball else R.drawable.pokeball_bw),
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.TopEnd)
                        .clickable(enabled = !isCatchingPokemon) {
                            isCatchingPokemon = true
                            val pokemonToUpdate = pokemon.copy(isFavorite = !isFavorite)
                            if (!isFavorite) {
                                roomViewModel.saveAsFavorite(pokemonToUpdate) {
                                    isCatchingPokemon = false
                                }
                            } else {
                                roomViewModel.deleteFavorite(pokemonToUpdate)
                                isCatchingPokemon = false
                            }
                        }
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = pokemon.name,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Tipus: ${
                        pokemon.type.name.lowercase().replaceFirstChar { it.uppercase() }
                    }",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = pokemon.type.color
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
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
