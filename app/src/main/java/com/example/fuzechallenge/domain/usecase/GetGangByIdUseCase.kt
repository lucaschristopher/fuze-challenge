package com.example.fuzechallenge.domain.usecase

import com.example.fuzechallenge.core.domain.UseCase
import com.example.fuzechallenge.data.repository.AppRepository
import com.example.fuzechallenge.domain.model.detail.Gang
import kotlinx.coroutines.flow.Flow

class GetGangByIdUseCase(
    private val repository: AppRepository
) : UseCase<String, Gang>() {

    override suspend fun execute(param: String): Flow<Gang> {
        return this.repository.getGangById(param)
    }
}