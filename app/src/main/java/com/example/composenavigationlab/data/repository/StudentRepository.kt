package com.example.composenavigationlab.data.repository

import com.example.composenavigationlab.data.model.Student

interface StudentRepository {

    fun getStudents(
        callback: (Result<List<Student>>) -> Unit
    )

    fun getStudent(
        id: Int,
        callback: (Result<Student>) -> Unit
    )

    fun searchStudents(
        query: String,
        callback: (Result<List<Student>>) -> Unit
    )
}
