package com.example.composenavigationlab.ui.home

import com.example.composenavigationlab.data.model.Student

data class HomeUiState(
    val isLoading: Boolean = false,
    val students: List<Student> = emptyList(),
    val errorMessage: String? = null
)
