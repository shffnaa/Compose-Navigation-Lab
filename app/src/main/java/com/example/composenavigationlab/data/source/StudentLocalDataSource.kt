package com.example.composenavigationlab.data.source

import com.example.composenavigationlab.data.model.Student

class StudentLocalDataSource {

    private val students = listOf(
        Student(7318, "Galaksi Bintang", "Teknik Informatika", 2023),
        Student(2045, "Biru Samudra", "Pendidikan Teknologi Informasi", 2026),
        Student(9182, "Esok Pradipta", "Teknik Komputer", 2024),
        Student(5621, "Soka Bachtera", "Sistem Informasi", 2025),
        Student(8473, "Senandika Aruna", "Teknik Informatika", 2025),
        Student(3196, "Aksa Naratama", "Sistem Informasi", 2026),
        Student(6854, "Nara Aksara", "Teknik Komputer", 2023),
        Student(1279, "Jingga Purnama", "Pendidikan Teknologi Informasi", 2024),
        Student(4938, "Langit Mahardika", "Teknologi Informasi", 2025),
        Student(8562, "Rasi Adinata", "Teknik Komputer", 2023),
        Student(2417, "Kala Baskara", "Teknik Informatika", 2025),
        Student(7903, "Arunika Sagara", "Sistem Informasi", 2026),
        Student(6341, "Niskala Dirgantara", "Teknik Informatika", 2023),
        Student(3859, "Awan Narendra", "Teknik Informatika", 2026),
        Student(9624, "Ranu Pramudya", "Pendidikan Teknologi Informasi", 2023),
        Student(5187, "Bumi Danadyaksa", "Teknik Komputer", 2026),
        Student(1736, "Senja Arunika", "Pendidikan Teknologi Informasi", 2025),
        Student(8249, "Naya Purnama", "Teknologi Informasi", 2024),
        Student(4563, "Elang Mahesa", "Teknik Informatika", 2025),
        Student(6902, "Kirana Larasati", "Teknik Komputer", 2024),
        Student(2835, "Aluna Seruni", "Sistem Informasi", 2022),
        Student(9471, "Alea Tanaya", "Teknik Informatika", 2026),
        Student(3658, "Nareswari Amara", "Pendidikan Teknologi Informasi", 2025),
        Student(7124, "Rengganis Kirana", "Sistem Informasi", 2026),
        Student(5392, "Baskara Adikara", "Teknik Komputer", 2024),
        Student(1864, "Sagara Nawasena", "Teknik Informatika", 2026),
        Student(8735, "Pradipta Aksan", "Pendidikan Teknologi Informasi", 2023),
        Student(4291, "Mahesa Dirga", "Teknik Komputer", 2026),
        Student(6547, "Larasati Nirmala", "Teknik Informatika", 2025),
        Student(2986, "Arawinda Kaluna", "Sistem Informasi", 2025)
    )

    fun getStudentById(id: Int): Student? =
        students.find { it.id == id }

    fun getStudents(): List<Student> = students
}