package com.example.testapi

import android.app.Application
import com.example.testapi.di.userApiModule
import com.example.testapi.di.userRetrofitModule
import com.example.testapi.di.userServiceModule
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
                    userApiModule
                )
            )
        }
    }
}