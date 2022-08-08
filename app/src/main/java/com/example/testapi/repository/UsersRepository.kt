package com.example.testapi.repository

interface UsersRepository {
    suspend fun getUsers(): UsersRepositoryResult
}