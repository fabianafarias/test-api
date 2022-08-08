package com.example.testapi.api.service

import com.example.testapi.response.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

//private const val API_KEY = "42a1bcf2fe20625750fcabb87c0b3143c75ea082f1b08a7e6f5c71297518ffb5"

interface UsersService {
    @GET
        ("users?access-token=42a1bcf2fe20625750fcabb87c0b3143c75ea082f1b08a7e6f5c71297518ffb5")
    suspend fun getUsers(): Response<UsersResponse>
}