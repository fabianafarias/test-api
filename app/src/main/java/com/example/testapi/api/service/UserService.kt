package com.example.testapi.api.service

import com.example.testapi.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getUsers() : Response<UserResponse>
}