package com.example.fuzechallenge.domain.di

import com.example.fuzechallenge.domain.usecase.GetMatchesUseCase
import com.example.fuzechallenge.domain.usecase.GetTeamsInfoUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val domainModule = module {
    factory { GetMatchesUseCase(repository = get()) }
    factory { GetTeamsInfoUseCase(repository = get()) }
}

object DomainModule {
    fun load() = loadKoinModules(domainModule)
}