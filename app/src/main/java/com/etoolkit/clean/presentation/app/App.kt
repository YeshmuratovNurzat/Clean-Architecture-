package com.etoolkit.clean.presentation.app

import android.app.Application
import com.etoolkit.clean.presentation.di.appModule
import com.etoolkit.clean.presentation.di.dataModule
import com.etoolkit.clean.presentation.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }


}