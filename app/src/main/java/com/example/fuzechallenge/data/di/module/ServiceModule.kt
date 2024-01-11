package com.example.fuzechallenge.data.di.module

import com.example.fuzechallenge.data.di.qualifier.RetrofitDefault
import com.example.fuzechallenge.data.provider.factory.ApiFactory
import com.example.fuzechallenge.data.service.CSGoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

    @Provides
    @Singleton
    fun provideCSGoService(
        @RetrofitDefault retrofit: Retrofit
    ): CSGoService =
        ApiFactory.build(
            retrofit = retrofit,
            apiClass = CSGoService::class.java
        )
}