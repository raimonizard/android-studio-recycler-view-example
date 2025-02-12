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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.andoidstudio_recyclerview_demo.viewmodel.getPokemonList

@Composable
fun DetailScreen(navController: NavController, pokemonName: String, modifier: Modifier = Modifier) {
    // Busquem el pokémon per nom dins de la llista usant un for-each amb iterador
    val pokemon = remember { getPokemonList().find { it.name == pokemonName } }

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
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(380.dp)
                        .clip(CircleShape)
                )

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
                onClick =
                {   // Quan es cliqui el botó anirà a la pàgina anterior
                    navController.popBackStack()
                },
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text("Tornar enrere")
            }
        }
    }
}
