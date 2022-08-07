package com.example.testapi.di

import com.example.testapi.api.service.UserApi
import com.example.testapi.api.service.UserService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://gorest.co.in/public/v2"

val userRetrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}

val userServiceModule = module {
    single {
        get<Retrofit>().create(UserService::class.java)
    }
}

val userApiModule = module {
    single<UserApi> {
        UserApi(get<UserService>())
    }
}



