package com.example.composenavigationlab.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composenavigationlab.data.repository.StudentRepository
import com.example.composenavigationlab.data.repository.FavoriteRepository

class DetailViewModelFactory(
    private val repository: StudentRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailViewModel(
                repository,
                favoriteRepository
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
