package com.example.composenavigationlab.data.remote

import com.example.composenavigationlab.data.remote.dto.UserDto
import com.example.composenavigationlab.data.remote.dto.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentRemoteDataSource(
    private val api: StudentApiService
) {

    fun getStudents(
        callback: (Result<List<UserDto>>) -> Unit
    ) {
        api.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    callback(Result.success(users))
                } else {
                    callback(
                        Result.failure(
                            Exception("Gagal mengambil data: ${response.code()}")
                        )
                    )
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun getStudent(
        id: Int,
        callback: (Result<UserDto>) -> Unit
    ) {
        api.getUser(id).enqueue(object : Callback<UserDto> {
            override fun onResponse(
                call: Call<UserDto>,
                response: Response<UserDto>
            ) {
                if (response.isSuccessful) {
                    val user = response.body()

                    if (user != null) {
                        callback(Result.success(user))
                    } else {
                        callback(
                            Result.failure(
                                Exception("Data pengguna tidak ditemukan")
                            )
                        )
                    }
                } else {
                    callback(
                        Result.failure(
                            Exception("Gagal mengambil detail: ${response.code()}")
                        )
                    )
                }
            }

            override fun onFailure(call: Call<UserDto>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun searchStudents(
        query: String,
        callback: (Result<List<UserDto>>) -> Unit
    ) {
        api.searchUsers(query).enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if (response.isSuccessful) {
                    val users = response.body()?.users ?: emptyList()
                    callback(Result.success(users))
                } else {
                    callback(
                        Result.failure(
                            Exception("Gagal mencari pengguna: ${response.code()}")
                        )
                    )
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }
}
