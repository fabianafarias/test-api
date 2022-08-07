package com.example.testapi.api.service

import com.example.testapi.dto.User

class UserApi(private val testService: UserService) {

    suspend fun getUsers(): UserApiResult {
        try {
            val userResponse = testService.getUsers()
            if (userResponse.isSuccessful) {
                userResponse.body()?.let {
                    val users: List<User> = it.users
                    return UserApiResult.Success(users)

                } ?: return UserApiResult.Error
            } else {
                return UserApiResult.Error
            }
        } catch (
            e: Exception
        ) {
            e.printStackTrace()
            return UserApiResult.Error
        }

    }

}