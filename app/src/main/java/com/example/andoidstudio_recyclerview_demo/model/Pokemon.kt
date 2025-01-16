package com.example.andoidstudio_recyclerview_demo.model

import androidx.annotation.DrawableRes

data class Pokemon(
    var name: String,
    var type: String,
    @DrawableRes var image: Int // És de tipus Int perquè internament Android Studio assigna un valor enter a cada element drawable
)