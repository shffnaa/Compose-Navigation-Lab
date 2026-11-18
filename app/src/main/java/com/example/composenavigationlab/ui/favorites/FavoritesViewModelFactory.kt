package com.example.composenavigationlab.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composenavigationlab.data.repository.FavoriteRepository

class FavoritesViewModelFactory(
    private val repository: FavoriteRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
