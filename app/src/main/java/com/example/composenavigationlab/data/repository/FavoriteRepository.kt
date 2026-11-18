package com.example.composenavigationlab.data.repository

import com.example.composenavigationlab.data.local.FavoriteStudentDao
import com.example.composenavigationlab.data.local.FavoriteStudentEntity
import com.example.composenavigationlab.data.model.Student
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(
    private val dao: FavoriteStudentDao
) {

    fun observeIsFavorite(id: Int): Flow<Boolean> =
        dao.observeIsFavorite(id)

    fun observeFavorites(): Flow<List<FavoriteStudentEntity>> =
        dao.observeFavorites()

    suspend fun add(student: Student) {
        dao.insert(
            FavoriteStudentEntity(
                id = student.id,
                name = student.name,
                email = student.email,
                university = student.university
            )
        )
    }

    suspend fun remove(id: Int) {
        dao.deleteById(id)
    }
}
