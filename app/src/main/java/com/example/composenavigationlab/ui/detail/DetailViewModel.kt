package com.example.composenavigationlab.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.composenavigationlab.data.repository.StudentRepository

class DetailViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(DetailUiState())
        private set

    fun loadStudent(id: Int) {
        uiState = DetailUiState(
            isLoading = true
        )

        repository.getStudent(id) { result ->
            result.onSuccess { student ->
                uiState = DetailUiState(
                    student = student
                )
            }.onFailure { error ->
                uiState = DetailUiState(
                    errorMessage = error.message
                        ?: "Gagal mengambil detail pengguna"
                )
            }
        }
    }

    companion object {
        fun factory(
            repository: StudentRepository
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>
                ): T {
                    if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
                        return DetailViewModel(repository) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    }
}
