package com.example.testapi.repository

import android.util.Log
import com.example.testapi.api.service.UserApi
import com.example.testapi.api.service.UserApiResult
import org.koin.core.component.KoinComponent

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository, KoinComponent {

    override suspend fun getUsers() : UserRepositoryResult {
        when (val userApiResult = userApi.getUsers()) {
            is UserApiResult.Success -> {
                userApiResult.userList.let {
                    Log.i("userRepository", "$it")

                    return UserRepositoryResult.Success(it)
                }
            }
            is UserApiResult.Error -> {
                return UserRepositoryResult.Error
            }
        }
    }

}