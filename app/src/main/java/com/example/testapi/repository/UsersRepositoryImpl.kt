package com.example.testapi.repository

import android.util.Log
import com.example.testapi.api.service.UserApi
import com.example.testapi.api.service.UsersApiResult
import org.koin.core.component.KoinComponent

class UsersRepositoryImpl(private val userApi: UserApi) : UsersRepository, KoinComponent {

    override suspend fun getUsers(): UsersRepositoryResult {
        when (val userApiResult = userApi.getUsers()) {
            is UsersApiResult.Success -> {
                userApiResult.userData.let {
                    return UsersRepositoryResult.Success(it)
                    Log.i("TAG", "Repository")
                }
            }
            is UsersApiResult.Error -> {
                return UsersRepositoryResult.Error
            }
        }
    }

}