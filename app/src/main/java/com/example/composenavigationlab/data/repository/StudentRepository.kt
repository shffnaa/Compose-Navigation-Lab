package com.example.composenavigationlab.data.repository

import com.example.composenavigationlab.data.model.Student
import com.example.composenavigationlab.data.source.StudentLocalDataSource

interface StudentRepository {

    fun getStudentById(id: Int): Student?

    fun getStudents(): List<Student>
}

class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource
) : StudentRepository {

    override fun getStudentById(id: Int): Student? {
        return dataSource.getStudentById(id)
    }

    override fun getStudents(): List<Student> {
        return dataSource.getStudents()
    }
}
