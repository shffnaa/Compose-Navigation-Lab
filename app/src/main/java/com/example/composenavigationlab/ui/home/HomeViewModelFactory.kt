package com.example.composenavigationlab.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composenavigationlab.data.repository.StudentRepository
import com.example.composenavigationlab.data.preferences.UserPreferencesRepository

class HomeViewModelFactory(
    private val repository: StudentRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                repository,
                preferencesRepository
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
