package com.example.testapi.api.service

import com.example.testapi.dto.UserData

class UserApi(private val usersService: UsersService) {

    suspend fun getUsers(): UsersApiResult {
        try {
            val userResponse = usersService.getUsers()
            if (userResponse.isSuccessful) {
                userResponse.body()?.let {
                    val userData: UserData = it.userData
                    return UsersApiResult.Success(userData)

                } ?: return UsersApiResult.Error
            } else {
                return UsersApiResult.Error
            }
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            return UsersApiResult.Error
        }

    }

}