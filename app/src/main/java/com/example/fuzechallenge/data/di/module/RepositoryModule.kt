package com.example.fuzechallenge.data.di.module

import com.example.fuzechallenge.data.datasource.remote.CSGoDataSource
import com.example.fuzechallenge.data.di.qualifier.IODispatcher
import com.example.fuzechallenge.data.repository.CSGoRepositoryImpl
import com.example.fuzechallenge.domain.repository.CSGoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Provides
    @Singleton

    fun providesCSGoRepository(
        remoteDataSource: CSGoDataSource,
        @IODispatcher dispatcher: CoroutineDispatcher
    ): CSGoRepository = CSGoRepositoryImpl(remoteDataSource, dispatcher)
}
