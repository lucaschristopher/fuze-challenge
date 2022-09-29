package com.example.fuzechallenge.presentation.di

import com.example.fuzechallenge.domain.usecase.AppUseCases
import com.example.fuzechallenge.domain.usecase.GetGangByIdUseCase
import com.example.fuzechallenge.domain.usecase.GetMatchesUseCase
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel
import com.example.fuzechallenge.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(appUseCases = get()) }
    viewModel { DetailViewModel(appUseCases = get()) }
}

val useCaseModule = module {
    factory { AppUseCases(getMatchesUseCase = get(), getGangByIdUseCase = get()) }
    factory { GetMatchesUseCase(repository = get()) }
    factory { GetGangByIdUseCase(repository = get()) }
}

object PresentationModule {
    fun load() = loadKoinModules(viewModelModule + useCaseModule)
}