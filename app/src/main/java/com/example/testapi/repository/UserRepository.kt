package com.example.testapi.repository

import com.example.testapi.api.service.UserApiResult

interface UserRepository {
    suspend fun getUsers(): UserRepositoryResult
}