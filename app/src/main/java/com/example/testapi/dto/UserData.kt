package com.example.testapi.dto

import com.google.gson.annotations.SerializedName

class UserData(private val user: User) {
    @SerializedName("id")
    private val id: Int = user.id

    @SerializedName("name")
    private val name: String = user.name

    @SerializedName("email")
    private val email: String = user.email

    @SerializedName("gender")
    private val gender: String = user.gender

    @SerializedName("status")
    private val status: String = user.status

}



