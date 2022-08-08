package com.example.testapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.repository.UsersRepository
import com.example.testapi.repository.UsersRepositoryResult
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class UsersViewModel(
    private val repository: UsersRepository
) : ViewModel(), KoinComponent {

    private val _userList = MutableLiveData<UsersViewModelResult>()
    val userList: LiveData<UsersViewModelResult> get() = _userList

    fun usersUpdate() {
        viewModelScope.launch {
            when (val userRepositoryResult = repository.getUsers()) {
                is UsersRepositoryResult.Success -> {
                    _userList.postValue(UsersViewModelResult.Success(userRepositoryResult.userData))
                }
                is UsersRepositoryResult.Error -> {
                    _userList.postValue(UsersViewModelResult.Error)
                }
            }
        }

    }

}