package com.example.fuzechallenge.presentation.di

import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel
import com.example.fuzechallenge.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(getMatchesUseCase = get()) }
    viewModel { DetailViewModel(getTeamsInfoUseCase = get()) }
}

object PresentationModule {
    fun load() = loadKoinModules(viewModelModule)
}