package com.example.composenavigationlab.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenavigationlab.data.local.FavoriteStudentEntity
import com.example.composenavigationlab.data.repository.FavoriteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class FavoritesViewModel(
    repository: FavoriteRepository
) : ViewModel() {

    val favorites: StateFlow<List<FavoriteStudentEntity>> =
        repository.observeFavorites().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}
