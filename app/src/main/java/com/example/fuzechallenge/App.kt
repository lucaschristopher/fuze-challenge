package com.example.fuzechallenge

import android.app.Application
import com.example.fuzechallenge.data.di.DataModule
import com.example.fuzechallenge.domain.di.DomainModule
import com.example.fuzechallenge.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        initKoin()
        loadModules()
    }

    private fun initKoin() {
        startKoin { androidContext(this@App) }
    }

    private fun loadModules() {
        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}