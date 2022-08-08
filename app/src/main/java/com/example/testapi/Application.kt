package com.example.testapi

import android.app.Application
import com.example.testapi.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    userRetrofitModule,
                    userServiceModule,
                    userApiModule,
                    userRepositoryModule,
                    usersViewModelModule
                )
            )
        }
    }
}