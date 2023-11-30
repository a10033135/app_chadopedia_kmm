package com.myapplication.di

import db.Database
import db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val db_module = module {
     single { DatabaseDriverFactory(androidApplication()) }
     single { Database(get()) }
}