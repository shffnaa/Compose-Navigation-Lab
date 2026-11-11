package com.example.composenavigationlab.ui.home

import com.example.composenavigationlab.data.model.Student

data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
