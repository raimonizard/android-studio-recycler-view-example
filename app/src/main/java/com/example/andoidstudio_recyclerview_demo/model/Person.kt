package com.example.andoidstudio_recyclerview_demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val firstname: String,
    val phoneNumber: String
)