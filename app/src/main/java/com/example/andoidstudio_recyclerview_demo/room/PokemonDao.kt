package com.example.andoidstudio_recyclerview_demo.room
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.andoidstudio_recyclerview_demo.model.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemons")
    fun getAll(): List<Pokemon>

    @Query("SELECT * FROM pokemons WHERE name = :name")
    fun findByName(name: String): List<Pokemon?>

    @Insert
    fun addFavorite(favoritePokemon: Pokemon)

    @Delete
    fun removeFavorite(favoritePokemon: Pokemon)

    @Query("UPDATE pokemons SET is_favorite = :isFavorite WHERE name = :name")
    fun updateFavoriteStatus(name: String, isFavorite: Boolean)
}