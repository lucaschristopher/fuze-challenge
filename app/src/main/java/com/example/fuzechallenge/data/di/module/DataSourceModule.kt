package com.example.fuzechallenge.data.di.module

import com.example.fuzechallenge.data.datasource.remote.CSGoDataSource
import com.example.fuzechallenge.data.datasource.remote.CSGoDataSourceImpl
import com.example.fuzechallenge.data.service.CSGoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    @Singleton
    fun provideCSGoDataSource(
        csGoService: CSGoService
    ): CSGoDataSource = CSGoDataSourceImpl(service = csGoService)
}
