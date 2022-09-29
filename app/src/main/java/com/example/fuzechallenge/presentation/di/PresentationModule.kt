package com.example.fuzechallenge.presentation.di

import com.example.fuzechallenge.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val presentationModule = module {
    viewModel { AppViewModel(getMatchesUseCase = get()) }
}

object PresentationModule {
    fun load() = loadKoinModules(presentationModule)
}