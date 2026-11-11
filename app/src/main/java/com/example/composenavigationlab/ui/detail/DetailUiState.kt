package com.example.composenavigationlab.ui.detail

import com.example.composenavigationlab.data.model.Student

data class DetailUiState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

