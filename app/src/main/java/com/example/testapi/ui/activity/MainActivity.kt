package com.example.testapi.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testapi.R
import com.example.testapi.ui.viewmodel.UsersViewModel
import com.example.testapi.ui.viewmodel.UsersViewModelResult
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val usersViewModel: UsersViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
        usersViewModel.usersUpdate()
    }

    private fun observeViewModel() {
        usersViewModel.userList.observe(this) {
            when (it) {
                is UsersViewModelResult.Success -> {
                    val users = it.userData
                    Log.i("TAG", "$users")
                }
                is UsersViewModelResult.Error -> {}
            }
        }


    }


}