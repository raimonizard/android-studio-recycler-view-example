package com.example.andoidstudio_recyclerview_demo.room
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemons WHERE is_favorite = 1")
    fun getCaptured(): MutableList<Pokemon>

    @Query("SELECT * FROM pokemons WHERE name = :name")
    fun findByName(name: String): MutableList<Pokemon?>

    @Query("SELECT is_favorite FROM pokemons WHERE name = :name")
    fun isCaptured(name: String): Boolean

    @Insert
    fun capturePokemon(favoritePokemon: Pokemon)

    @Delete
    fun freePokemon(favoritePokemon: Pokemon)

    @Query("UPDATE pokemons SET is_favorite = :isFavorite WHERE name = :name")
    fun updateCapturedStatus(name: String, isFavorite: Boolean)
}