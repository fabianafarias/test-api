package com.example.testapi.api.service

import com.example.testapi.dto.User

sealed class UserApiResult {
    data class Success(val userList: List<User>) : UserApiResult()
    object Error : UserApiResult()
}
