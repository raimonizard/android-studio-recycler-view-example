import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.navigation.NavController
import com.example.andoidstudio_recyclerview_demo.model.Pokemon
import com.example.andoidstudio_recyclerview_demo.viewmodel.getPokemonList

@Composable
fun DetailScreen(modifier: Modifier, navController: NavController, pokemonName: String){
    var pokemon: Pokemon? = null

    for (p in getPokemonList())
        if (p.name == pokemonName)
            pokemon = p

    if (pokemon != null){
        Column(Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
    Button(onClick = { navController.popBackStack() }) {
        Text("Tornar enrere")
    }
}