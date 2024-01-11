package com.example.fuzechallenge.domain.di

import com.example.fuzechallenge.domain.usecase.list.GetMatchesUseCase
import com.example.fuzechallenge.domain.usecase.list.GetMatchesUseCaseImpl
import com.example.fuzechallenge.domain.usecase.detail.GetTeamsInfoUseCase
import com.example.fuzechallenge.domain.usecase.detail.GetTeamsInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal interface UseCaseModule {

    @Binds
    fun providesGetMatchesUseCase(
        useCaseImpl: GetMatchesUseCaseImpl
    ): GetMatchesUseCase

    @Binds
    fun providesGetTeamsInfoUseCase(
        useCaseImpl: GetTeamsInfoUseCaseImpl
    ): GetTeamsInfoUseCase
}
