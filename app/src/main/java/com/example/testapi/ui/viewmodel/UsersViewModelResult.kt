package com.example.testapi.ui.viewmodel

import com.example.testapi.dto.UserData

sealed class UsersViewModelResult {
    data class Success(val userData: UserData) : UsersViewModelResult()
    object Error : UsersViewModelResult()
}
