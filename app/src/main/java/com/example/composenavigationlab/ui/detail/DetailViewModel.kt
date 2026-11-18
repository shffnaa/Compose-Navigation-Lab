package com.example.composenavigationlab.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenavigationlab.data.model.Student
import com.example.composenavigationlab.data.repository.StudentRepository
import com.example.composenavigationlab.data.repository.FavoriteRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: StudentRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private var favoriteJob: Job? = null

    fun loadStudent(id: Int) {
        viewModelScope.launch {
            _uiState.value = DetailUiState(isLoading = true)

            try {
                val student = repository.getStudent(id)

                _uiState.value = DetailUiState(
                    student = student
                )

                if (student != null) {
                    observeFavorite(id)
                }

            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = DetailUiState(
                    errorMessage = e.message ?: "Data tidak tersedia"
                )
            }
        }
    }

    private fun observeFavorite(id: Int) {
        favoriteJob?.cancel()

        favoriteJob = viewModelScope.launch {
            favoriteRepository.observeIsFavorite(id).collect { value ->
                _uiState.update {
                    it.copy(isFavorite = value)
                }
            }
        }
    }

    fun toggleFavorite() {
        val student = uiState.value.student ?: return

        viewModelScope.launch {
            if (uiState.value.isFavorite) {
                favoriteRepository.remove(student.id)
            } else {
                favoriteRepository.add(student)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        favoriteJob?.cancel()
    }
}

