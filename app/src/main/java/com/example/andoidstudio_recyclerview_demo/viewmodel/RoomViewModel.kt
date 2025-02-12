package com.example.andoidstudio_recyclerview_demo.viewmodel

import com.example.andoidstudio_recyclerview_demo.model.Character
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andoidstudio_recyclerview_demo.room.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomViewModel : ViewModel(){
    private val repository = Repository()

    private val _loading = MutableLiveData(true)
    val loading = _loading

    private val _isFavorite = MutableLiveData(false)
    val isFavorite = _isFavorite

    private val _favorites = MutableLiveData<MutableList<Character>>()
    val favorites = _favorites

    fun getFavorites(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getFavorites()
            withContext(Dispatchers.Main){
                _favorites.value = response
                _loading.value = false
            }
        }
    }

    fun isFavorite(character: Character){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.isFavorite(character)
            withContext(Dispatchers.Main){
                _isFavorite.value = response
            }
        }
    }

    fun saveAsFavorite(character: Character){
        CoroutineScope(Dispatchers.IO).launch {
            repository.saveAsFavorite(character)
        }
    }

    fun deleteFavorite(character: Character){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteFavorite(character)
        }
    }

}