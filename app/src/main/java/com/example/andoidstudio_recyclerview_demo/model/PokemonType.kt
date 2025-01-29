package com.example.andoidstudio_recyclerview_demo.model

import androidx.compose.ui.graphics.Color

enum class PokemonType(val color: Color) {
    FIRE(Color(0xFFFF6F00)),  // Color taronja fosc per Foc
    WATER(Color(0xFF1E88E5)), // Blau per Aigua
    GRASS(Color(0xFF388E3C)), // Verd per Plante
    ELECTRIC(Color(0xFFFFEB3B)), // Groc per Elèctric
    ICE(Color(0xFF00ACC1)),    // Blau clar per Gel
    GHOST(Color(0xFF8E24AA)),  // Porpra per Fantasma
    FAIRY(Color(0xFFFF4081)),  // Rosa per Fada
    NORMAL(Color(0xFF9E9E9E)), // Gris per Normal
    PSYCHIC(Color(0xFF9C27B0)), // Violeta per Psíquic
    FIGHTING(Color(0xFFD32F2F)), // Vermell per Lluitador
    POISON(Color(0xFF9C27B0)),  // Violet per Verí
    DRAGON(Color(0xFF1976D2)), // Blau profund per Drac
    DARK(Color(0xFF212121)),    // Negre per Foscor
    STEEL(Color(0xFF607D8B)),   // Gris per Acero
    BUG(Color(0xFF4CAF50)),     // Verd fosc per Insecte
    ROCK(Color(0xFF795548)),    // Marró per Pedra
    GROUND(Color(0xFF8D6E63)),  // Marró fosc per Terra
}
