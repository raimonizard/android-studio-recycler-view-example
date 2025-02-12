package com.example.andoidstudio_recyclerview_demo.model

// Necessari importar per poder usar persistència de dades
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "characters")
data class Character(
   @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val images: List<String>,
    val jutsu: List<String>,
    val name: String,
    val natureType: List<String>,
    val tools: List<String>
)