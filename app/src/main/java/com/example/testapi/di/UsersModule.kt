package com.example.testapi.di

import com.example.testapi.api.service.UserApi
import com.example.testapi.api.service.UsersService
import com.example.testapi.repository.UsersRepository
import com.example.testapi.repository.UsersRepositoryImpl
import com.example.testapi.ui.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//const val BASE_URL = "https://gorest.co.in/public/v2/"

val userRetrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://gorest.co.in/public/v2/")
            .build()
    }
}

val userServiceModule = module {
    single {
        get<Retrofit>().create(UsersService::class.java)
    }
}

val userApiModule = module {
    single<UserApi> {
        UserApi(get<UsersService>())
    }
}

val userRepositoryModule = module {
    single<UsersRepository> {
        UsersRepositoryImpl(get<UserApi>())
    }
}

val usersViewModelModule = module {
    viewModel<UsersViewModel> {
        UsersViewModel(get<UsersRepository>())
    }
}



