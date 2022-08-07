package com.example.testapi.repository

import com.example.testapi.dto.User

sealed class UserRepositoryResult {
    data class Success(val userList: List<User>) : UserRepositoryResult()
    object Error : UserRepositoryResult()
}
