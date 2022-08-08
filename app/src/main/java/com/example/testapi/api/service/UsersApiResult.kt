package com.example.testapi.api.service

import com.example.testapi.dto.UserData

sealed class UsersApiResult {
    data class Success(val userData: UserData) : UsersApiResult()
    object Error : UsersApiResult()
}
