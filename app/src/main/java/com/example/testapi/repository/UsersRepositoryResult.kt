package com.example.testapi.repository

import com.example.testapi.dto.UserData

sealed class UsersRepositoryResult {
    data class Success(val userData: UserData) : UsersRepositoryResult()
    object Error : UsersRepositoryResult()
}
