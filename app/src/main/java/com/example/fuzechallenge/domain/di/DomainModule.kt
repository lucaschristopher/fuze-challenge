package com.example.fuzechallenge.domain.di

import com.example.fuzechallenge.domain.usecase.GetMatchesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMatchesUseCase(repository = get())
    }
}

object DomainModule {
    fun load() = loadKoinModules(domainModule)
}