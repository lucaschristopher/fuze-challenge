package com.example.fuzechallenge.domain.usecase.detail

import com.example.fuzechallenge.domain.model.Gang
import com.example.fuzechallenge.domain.repository.CSGoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal interface GetTeamsInfoUseCase { // FIXME
    suspend operator fun invoke(param: List<Long>): Flow<List<Gang>>
}

internal class GetTeamsInfoUseCaseImpl @Inject constructor(
    private val repository: CSGoRepository
) : GetTeamsInfoUseCase {
    override suspend operator fun invoke(param: List<Long>): Flow<List<Gang>> {
        return this.repository.getTeamsDetails(param)
    }
}