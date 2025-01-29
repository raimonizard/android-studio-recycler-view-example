@Composable
fun DetailScreen(navController: NavController, pokemonName: String){
    val pokemon: Pokemon = getPokemonList().find { it.name == pokemonName }
    if (pokemon != null){
        Column(Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
        }
    }
}