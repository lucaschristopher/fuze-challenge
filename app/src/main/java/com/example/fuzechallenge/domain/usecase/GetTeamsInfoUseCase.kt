package com.example.fuzechallenge.domain.usecase

import com.example.fuzechallenge.data.repository.AppRepository
import com.example.fuzechallenge.domain.model.detail.Gang
import kotlinx.coroutines.flow.Flow

class GetTeamsInfoUseCase(
    private val repository: AppRepository
) : UseCase<List<Long>, List<Gang>>() {

    override suspend fun execute(param: List<Long>): Flow<List<Gang>> {
        return this.repository.getTeamsInfo(param)
    }
}