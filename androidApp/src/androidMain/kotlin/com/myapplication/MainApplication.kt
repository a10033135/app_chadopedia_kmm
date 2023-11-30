package com.myapplication

import android.app.Application
import com.myapplication.di.db_module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(db_module)
        }
    }
}